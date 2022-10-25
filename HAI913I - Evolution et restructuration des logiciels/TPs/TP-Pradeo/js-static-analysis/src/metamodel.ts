export class Metamodel {
  constructor() {
    this.functions = [];
    this.classes = [];
  }

  public readonly main = () => this.functions[0];
  public readonly functions: Function[];
  public readonly classes: Klass[];
}

export class Function {
  constructor(public name: string) {
    this.instructions = [];
    this.variables = new Set();
  }

  public label(): string {
    return this.name;
  }

  public modify(variable: string): Expression[] {
    const result: Expression[] = [];

    for (const instruction of this.instructions) {
      instruction.visit((node) => {
        if (node.kind === "AssignmentExpression") {
          if (
            ((node as AssignmentExpression).left as Identifier).name ===
            variable
          ) {
            result.push((node as AssignmentExpression).right);
          }
        }
      });
    }

    return result;
  }

  public instructions: Instruction[];
  public variables: Set<string>;
}

export class Method extends Function {
  constructor(public name: string, public on: Klass) {
    super(name);
  }

  public override label(): string {
    return `${this.on.name}::${this.name}`;
  }
}

export class Klass {
  constructor(public name: string, public superClass: Expression | null) {
    this.methods = [];
  }

  public readonly methods: Function[];
}

export abstract class Node {
  public kind = this.constructor.name as
    | "Nop"
    | "ExpressionStatement"
    | "CallExpression"
    | "AssignmentExpression"
    | "MemberExpression"
    | "NewExpression"
    | "Identifier"
    | "Literal"
    | "ThisExpression"
    | "ObjectExpression";

  public visit(callback: (node: Node) => void): void {
    callback(this);
  }
}

export type Instruction = Nop | ExpressionStatement;

export type Expression =
  | ExpressionStatement
  | CallExpression
  | AssignmentExpression
  | MemberExpression
  | NewExpression
  | ThisExpression
  | Identifier
  | Literal
  | ObjectExpression;

export class Nop extends Node {}

export class ExpressionStatement extends Node {
  constructor(public expression: Expression) {
    super();
  }

  public visit(callback: (node: Node) => void) {
    super.visit(callback);

    this.expression.visit(callback);
  }
}

export class CallExpression extends Node {
  constructor(public callee: Expression, public args: Expression[]) {
    super();

    this.arguments = args;
  }

  public visit(callback: (node: Node) => void) {
    super.visit(callback);

    this.callee.visit(callback);

    for (const argument of this.arguments) {
      argument.visit(callback);
    }
  }

  public readonly arguments: Expression[];
}

export class AssignmentExpression extends Node {
  constructor(public left: Expression, public right: Expression) {
    super();
  }

  public visit(callback: (node: Node) => void) {
    super.visit(callback);

    this.left.visit(callback);
    this.right.visit(callback);
  }
}

export class MemberExpression extends Node {
  constructor(public object: Expression, public property: Expression) {
    super();
  }

  public visit(callback: (node: Node) => void) {
    super.visit(callback);

    this.object.visit(callback);
    this.property.visit(callback);
  }
}

export class NewExpression extends Node {
  constructor(public callee: Expression) {
    super();
  }

  public visit(callback: (node: Node) => void) {
    super.visit(callback);

    this.callee.visit(callback);
  }
}

export class ThisExpression extends Node {}

export class Identifier extends Node {
  public constructor(public name: string) {
    super();
  }
}

export class Literal extends Node {
  public constructor(public value: string) {
    super();
  }
}

export class ObjectExpression extends Node {}
