
abstract class Cycle
{
  public abstract String getName();
  public String getMake()
  {
    return "Hercules";
  }
}

class Dinesh  implements Person
{
  public String getName()
  {
    return "Dinesh cycele";
  }

  public int getAge()
  {
    return 22;
  }
}

interface Person
{
  public String getName();
  public int getAge();
}

class Prabha extends Cycle
{
  public String getName()
  {
    return "Prabha cycele";
  }

  public String getMake()
  {
    return "otta cycle";
  }
}

public class AbstractTest
{
  public static void main ( String arg[] )
  {
    Person c1 = new Dinesh();
    System.out.println(c1.getMake() + "     " + c1.getName());

    Cycle c2 = new Prabha();
    System.out.println(c2.getMake() + "     " + c2.getName());
  }
}
