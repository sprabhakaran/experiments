function iPerson() {
    return {
        firtName: "iam",
        lastName: "spk",
        sayHi: function () {
            return "Hiii";
        }
    };
}
var i = iPerson();
console.log(i);
function getInter() {
    return {
        getOne: function () {
            return "Oneeeee";
        }
    };
}
var t = getInter();
if (t instanceof Type) {
}
// console.log(t.getOne()); //Error
