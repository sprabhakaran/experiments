var x;
console.log(typeof (x));
var y = 20;
console.log(typeof (y));
var z = "";
console.log(typeof (z));
var Person = /** @class */ (function () {
    function Person() {
    }
    Person.prototype.getName = function () {
        return " getting name ";
    };
    Person.prototype.getEmployee = function () {
        return new Employee();
    };
    return Person;
}());
var Employee = /** @class */ (function () {
    function Employee() {
    }
    return Employee;
}());
var person = new Person();
console.log(typeof (person));
console.log(person instanceof Person);
console.log(person.constructor.name);
