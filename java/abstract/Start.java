
abstract class Animal {  
  public abstract void doAction();  
}

class Dog extends Animal {  
  public void doAction() {System.out.println("run");} 
}

class Cat extends Animal {  
  public void doAction() {System.out.println("sleep");}
}

class RunActions {  
  public void runAction(Animal a) {
    a.doAction();
  }
}

public class Start {
  public static void main(String args[]) 
  {
    Animal animal = new Dog();
    Animal animal1 = new Cat();
    new RunActions().runAction(animal); // Problem!
    new RunActions().runAction(animal1); // Problem!
  }
}
