const repl = require('repl');

const state = {
  printSomething: function() {
    console.log("That's awesome!");
  }
};

const myRepl = repl.start("stefan's repl > ");

process.on('uncaughtException', () => console.log('Uncaught dubuku error!'));


//minor changes

throw new Error('foobar');


Object.assign(myRepl.context, state);
