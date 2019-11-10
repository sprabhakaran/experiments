const recast = require('recast');
const { Parser } = require("acorn");
const fs = require("fs");
const ast = Parser.parse(fs.readFileSync("./test.js").toString());

recast.visit(ast, visitFunctionDeclaration(path){
  // deal with the path here...

  // run the visit on every child node
  this.traverse(path);
})
