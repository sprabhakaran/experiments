import java.lang.reflect.*;
public class UnsafeDemo 
{
  public static void main(String[] args) throws NoSuchFieldException, SecurityException, 
         IllegalArgumentException, IllegalAccessException, InstantiationException 
         {
           Field f = Unsafe.class.getDeclaredField("theUnsafe"); //Internal reference
           f.setAccessible(true);
           Unsafe unsafe = (Unsafe) f.get(null);

           //This creates an instance of player class without any initialization
           Player p = (Player) unsafe.allocateInstance(Player.class);
           System.out.println(p.getAge());     //Print 0

           p.setAge(45);                       //Let's now set age 45 to un-initialized object
           System.out.println(p.getAge());     //Print 45

           System.out.println(new Player().getAge());  //This the normal way to get fully initialized object; Prints 50
         }
}

class Player{
  private int age = 12;

  public Player(){        //Even if you create this constructor private; 
    //You can initialize using Unsafe.allocateInstance()
    this.age = 50;
  }
  public int getAge(){
    return this.age;
  }
  public void setAge(int age){
    this.age = age;
  }
}
