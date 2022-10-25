import { readFile } from "fs";
import { join } from "path";
import { promisify } from "util";

import { parse } from "acorn";
import { simple } from "acorn-walk";
import {
  CallExpression,
  Expression,
  ExpressionStatement,
  Function,
  Identifier,
  Literal,
  MemberExpression,
  Metamodel,
  Nop,
  Klass,
  ThisExpression,
  Method,
  AssignmentExpression,
  Instruction,
  NewExpression,
  ObjectExpression,
} from "./metamodel";
import assert from "assert";

export async function load(path: string): Promise<Metamodel> {
  const result = new Metamodel();

  const ast: any = parse(
    await promisify(readFile)(join("samples", path), "utf-8"),
    {
      ecmaVersion: "latest",
    }
  );

  simple(ast, {
    Program(node: any) {
      const main = new Function("main");

      for (const statement of node.body) {
        for (const instruction of instructions(statement, main)) {
          main.instructions.push(instruction);
        }
      }

      result.functions.push(main);
    },
  });

  simple(ast, {
    FunctionDeclaration(node: any) {
      makeFunction(result, node);
    },
  });

  simple(ast, {
    ClassDeclaration(node: any) {
      makeClass(result, node);
    },
  });

  return result;
}

function makeFunction(metamodel: Metamodel, node: any): Function {
  const result = new Function(identifier(node.id));

  for (const statement of node.body.body) {
    for (const instruction of instructions(statement, result)) {
      result.instructions.push(instruction);
    }
  }

  metamodel.functions.push(result);

  return result;
}

function makeMethod(
  metamodel: Metamodel,
  node: any,
  name: string,
  on: Klass
): Method {
  const result = new Method(name, on);

  for (const statement of node.body.body) {
    for (const instruction of instructions(statement, result)) {
      result.instructions.push(instruction);
    }
  }

  metamodel.functions.push(result);

  return result;
}

function makeClass(metamodel: Metamodel, node: any): Klass {
  const result = new Klass(
    identifier(node.id),
    node.superClass === null ? null : expression(node.superClass)
  );

  for (const definition of node.body.body) {
    switch (definition.type) {
      case "MethodDefinition":
        result.methods.push(
          makeMethod(metamodel, definition.value, definition.key.name, result)
        );
        break;
    }
  }

  metamodel.classes.push(result);

  return result;
}

function identifier(node: any): string {
  switch (node.type) {
    case "Identifier":
      return node.name;
    default:
      assert(false, "An identifier has an unknown type");
  }
}

function instructions(node: any, current: Function): Instruction[] {
  let result: Instruction[] = [];

  switch (node.type) {
    case "ExpressionStatement":
      result.push(new ExpressionStatement(expression(node.expression)));
      break;
    case "VariableDeclaration":
      for (const declarator of node.declarations) {
        current.variables.add(declarator.id.name);

        if (declarator.init) {
          result.push(
            new AssignmentExpression(
              expression(declarator.id),
              expression(declarator.init)
            )
          );
        }
      }
      break;
    case "ClassDeclaration":
    case "FunctionDeclaration":
    case "ReturnStatement":
      // Ignore
      break;
    default:
      console.log(`Not managed ${node.type} statement`);
      console.log(JSON.stringify(node, null, 2));
  }

  return result;
}

function expression(node: any): Expression {
  switch (node.type) {
    case "MemberExpression":
      return new MemberExpression(
        expression(node.object),
        expression(node.property)
      );
    case "CallExpression":
      return new CallExpression(
        expression(node.callee),
        node.arguments.map(expression)
      );
    case "AssignmentExpression":
      return new AssignmentExpression(
        expression(node.left),
        expression(node.right)
      );
    case "NewExpression":
      return new NewExpression(expression(node.callee));
    case "ThisExpression":
      return new ThisExpression();
    case "Identifier":
      return new Identifier(node.name);
    case "Literal":
      return new Literal(node.value);
    case "ObjectExpression":
      return new ObjectExpression();
    default:
      console.log(`Not managed ${node.type} expression`);
      console.log(JSON.stringify(node, null, 2));

      assert(false);
  }
}
