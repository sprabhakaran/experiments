interface Prototype 
{
  public abstract Object clone ( );
}



 class ConcretePrototype implements Prototype {
  public Object clone()  throws java.lang.CloneNotSupportedException{
    return super.clone();
  }
}

public class Client {

  public static void main( String arg[] ) 
  {
    ConcretePrototype obj1= new ConcretePrototype ();
    ConcretePrototype obj2 = (ConcretePrototype)obj1.clone();
  }

}
