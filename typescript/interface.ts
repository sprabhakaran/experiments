
interface Person {
    firtName: string,
    lastName: string,
    sayHi: ()=>string
}

function iPerson():Person{
    return {
        firtName: "iam",
        lastName: "spk",
        sayHi: function () {
            return "Hiii";
        }
    }
}

var i = iPerson();
console.log(i);



//-------



interface  One {
    getOne: () => string
}

interface Two {
    getTwo: () => string
}

interface Three {
    getThree: () => string
}

function getInter():One|Two|Three {
    return {
        getOne: function () {
            return "Oneeeee";
        }
    }
}

type Type = One | Two | Three;

console.log(Type);

var t:One|Two|Three = getInter();

// if (t instanceof Type){
//
// }

// console.log(t.getOne()); //Error