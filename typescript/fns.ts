function disp(s1: string): void;
function disp(n1: number, s1: string): void;
function disp(n1: number, s1: string, s3: number): void;

function disp(x: any, y?: any, z?: Number): void {
    console.log(x);
    console.log(y);
    console.log(z);
}

disp("abc");

disp(1, "xyz");

function disp(s1: number, s12: string, number: number) {
    console.log("v1 " + s1);
    console.log("v2 " + s12);
    console.log("v3 " + number);
}

disp(10, "str1", 10);


