public class Employee extends Object implements Cloneable
{
  private String name;
  private String identifier;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIdentifier() {
    return identifier;
  }
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /*public Object clone() throws Exception
  {
    return super.clone();
  }*/

  public String toString()
  {
    return this.name + "      " + this.identifier;
  }

  /*public void print() {
    System.out.println(Objects.toStringHelper(this).add("name:", name).add("id:", identifier).toString());
  }*/

  public static void main(String[] args) throws Exception {
    Employee employee1 = new Employee();
    employee1.setName("Ram");
    employee1.setIdentifier("1");
    System.out.println("1: "+employee1);
    //employee1.print();

    Employee employee2 = (Employee)employee1.clone();
    System.out.println("2: "+employee2);
    //employee2.print();
  }
}
