const fs = require('fs');
const acorn = require("acorn")
const walk = require("acorn-walk")

    // DOC : https://github.com/estree/estree/blob/master/es5.md


try {
    const data = fs.readFileSync('toParse.ts', 'utf8');
    
    console.log("File read [DONE]");



    let json = acorn.parse(data, {ecmaVersion: 2020});

    // console.log(JSON.stringify(json, null, 2)) ;


    walk.simple( json , {

        FunctionDeclaration(node) {
            let params = "" ;
            for (let i = 0; i < node.params.length; i++) {
                params += node.params[i].name;
                if (i != node.params.length-1) {
                    params += ", " ;

                }
            }
            console.log("Function found : " + node.id.name + "("+params+")") ;
            //console.log(JSON.stringify(node, null, 2) + "\n\n\n\n\n") ;
        }
      })

    



  } catch (err) {
    console.error(err);
}