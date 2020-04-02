const repl = require('repl');

const r = repl.start({ 
  prompt: '> ', 
  eval: myEval, 
  writer: myWriter, 
  userColors: true 
});

const state = {
  
  printHello: () => {
    return "Hi hello";
  }

}

Object.assign(r.context, state);

function myEval(cmd, context, filename, callback) {
  console.log("command :: " , cmd, "filename:: ", filename);
  callback(null, cmd);
}

function myWriter(output) {
  console.log("output ::: ", output);
  console.log("----- ",output, "::: ls");
  if(output === "ls"){
    console.log("listing files");
  }
  return output;
}

r.defineCommand('sayhello', {
  help: 'Say hello',
  action(name) {
    this.clearBufferedCommand();
    console.log(`Hello, ${name}!`);
    this.displayPrompt();
  }
});
r.defineCommand('saybye', function saybye() {
  console.log('Goodbye!');
  this.close();
});

r.on('exit', () => {
  console.log("exiting ...");
  //process.exit();
});

