

var x:Number;

console.log(typeof(x));

var y = 20;
console.log(typeof(y));


var z = "";
console.log(typeof(z));




class Person {

  getName():string {

    return " getting name ";
  }

  getEmployee():Employee{
    return new Employee();
  }
}

class Employee{

}
var person:Person = new Person();

console.log(typeof(person));
console.log(person instanceof Person);
console.log(person.constructor.name);
