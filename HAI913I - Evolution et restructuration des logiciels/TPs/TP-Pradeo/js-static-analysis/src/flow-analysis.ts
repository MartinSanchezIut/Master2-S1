import {
  CallExpression,
  Function,
  Identifier,
  MemberExpression,
  Metamodel,
} from "./metamodel";

import { Node, Edge } from "vis-network";

export function reachabilityAnalysis(metamodel: Metamodel): {
  nodes: Array<Node>;
  edges: Array<Edge>;
} {
  const nodes: Array<Node> = [];
  const edges: Array<Edge> = [];

  function findTargets(current: Function, call: CallExpression): Function[] {
    // Compute function with same name
    const result: Function[] = [];

    const lookingFor = (() => {
      let result: string | null = null;

      if (call.callee.kind === "Identifier") {
        const callee = call.callee as Identifier;

        result = callee.name;
      }

      if (call.callee.kind === "MemberExpression") {
        const callee = call.callee as MemberExpression;

        result = (callee.property as Identifier).name;
      }

      return result;
    })();

    if (lookingFor) {
      for (const fct of metamodel.functions) {
        if (fct.name === lookingFor) {
          result.push(fct);
        }
      }
    }

    return result;
  }

  for (const [id, current] of Object.entries(metamodel.functions)) {
    nodes.push({
      id: Number(id),
      label: current.label(),
    });
  }

  // Reach a fixpoint
  while (true) {
    let oneChange = false;

    for (const [id, current] of Object.entries(metamodel.functions)) {
      for (const instruction of current.instructions) {
        instruction.visit((node) => {
          if (node.kind === "CallExpression") {
            const call = node as CallExpression;

            for (const target of findTargets(current, call)) {
              const from = Number(id);
              const to = metamodel.functions.indexOf(target);

              const alreadyExists =
                edges.findIndex((e) => e.from === from && e.to === to) !== -1;

              if (!alreadyExists) {
                edges.push({
                  from,
                  to,
                });

                oneChange = true;
              }
            }
          }
        });
      }
    }

    if (!oneChange) break;
  }

  return { nodes, edges };
}

export function classHierarchyAnalysis(metamodel: Metamodel): {
  nodes: Array<Node>;
  edges: Array<Edge>;
} {
  // Compute function with same name
  const nodes: Array<Node> = [];
  const edges: Array<Edge> = [];

  function findTargets(current: Function, call: CallExpression): Function[] {
    // Compute function with same name
    const result: Function[] = [];

    const [lookingFor, isMethod] = (() => {
      let result: [string | null, boolean] = [null, false];

      if (call.callee.kind === "Identifier") {
        const callee = call.callee as Identifier;

        result = [callee.name, false];
      }

      if (call.callee.kind === "MemberExpression") {
        const callee = call.callee as MemberExpression;

        result = [(callee.property as Identifier).name, true];
      }

      return result;
    })();

    if (lookingFor) {
      for (const fct of metamodel.functions) {
        if (fct.name === lookingFor) {
          if (isMethod) {
            if (fct.constructor.name === "Method") {
              result.push(fct);
            }
          } else {
            if (fct.constructor.name === "Function") {
              result.push(fct);
            }
          }
        }
      }
    }

    return result;
  }

  for (const [id, current] of Object.entries(metamodel.functions)) {
    nodes.push({
      id: Number(id),
      label: current.label(),
    });
  }

  // Reach a fixpoint
  while (true) {
    let oneChange = false;

    for (const [id, current] of Object.entries(metamodel.functions)) {
      for (const instruction of current.instructions) {
        instruction.visit((node) => {
          if (node.kind === "CallExpression") {
            const call = node as CallExpression;

            for (const target of findTargets(current, call)) {
              const from = Number(id);
              const to = metamodel.functions.indexOf(target);

              const alreadyExists =
                edges.findIndex((e) => e.from === from && e.to === to) !== -1;

              if (!alreadyExists) {
                edges.push({
                  from,
                  to,
                });

                oneChange = true;
              }
            }
          }
        });
      }
    }

    if (!oneChange) break;
  }

  return { nodes, edges };
}

export function rapidTypeAnalysis(metamodel: Metamodel): {
  nodes: Array<Node>;
  edges: Array<Edge>;
} {
  // Compute function with same name
  const nodes: Array<Node> = [];
  const edges: Array<Edge> = [];

  return { nodes, edges };
}

