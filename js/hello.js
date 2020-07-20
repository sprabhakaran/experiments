
const repl = require('repl');

repl.start("~ $ ");

repl.context.ls = function(){
  return "Hello";
}


