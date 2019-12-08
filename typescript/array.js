var arr = new Array(1);
arr[0] = 1;
arr[1] = 1;
arr[2] = 1;
arr[3] = 1;
arr[4] = 1;
arr[5] = 1;
arr[6] = 1;
arr.push(1, 2, 3, 4, 5, 6, "one", "tow", "three", "four", "five", "six");
console.log(arr);
console.log(arr.length);
console.log(typeof (arr));
function returnArr() {
    return [10];
}
console.log(returnArr());
