import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class PropertyChageTest 
{
  public static void main(String[] argv) throws Exception 
  {
    MyBean bean = new MyBean();
    bean.setName("A");
    bean.setName("B");
    bean.setName("C");
  }
}
class MyBean implements PropertyChangeListener, Serializable
{
  private Long id;
  private String name;
  private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public MyBean() {
    pcs.addPropertyChangeListener(this);
  }

  public void propertyChange(PropertyChangeEvent evt) {
    System.out.println("Name      = " + evt.getPropertyName());
    System.out.println("Old Value = " + evt.getOldValue());
    System.out.println("New Value = " + evt.getNewValue());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    String oldValue = this.name;
    this.name = name;
    pcs.firePropertyChange("name", oldValue, name);
  }
}
