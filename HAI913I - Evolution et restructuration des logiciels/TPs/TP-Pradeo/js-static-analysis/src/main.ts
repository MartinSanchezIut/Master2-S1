// import { reachabilityAnalysis } from "./flow-analysis";
import { load } from "./load";
import { reachabilityAnalysis } from "./flow-analysis";
import { classHierarchyAnalysis } from "./flow-analysis";
import { rapidTypeAnalysis } from "./flow-analysis";

async function main() {
  const metamodel = await load("test.js");

  // console.log(metamodel.main().instructions);

  // console.log(reachabilityAnalysis(metamodel));
  // console.log(classHierarchyAnalysis(metamodel));
  // console.log(rapidTypeAnalysis(metamodel));

  console.log(metamodel.main().modify("b"));
}

main();
