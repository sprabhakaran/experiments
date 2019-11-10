
var x:number|string|Date = "string";

x = get_val();

// console.log(x.toString(0));

console.log("x is " + x);

function get_val(): any{
    return 100;
}


var arr:string[]|number[] = new Array(5);
arr[0] = 1;
arr[1] = "";
arr[2] = new Date().getMilliseconds();
arr[3] = 4;
arr[4] = 34;

console.log(arr);