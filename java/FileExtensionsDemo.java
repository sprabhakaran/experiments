import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;


public class FileExtensionsDemo {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    List<ScriptEngineFactory> factories = manager.getEngineFactories();
    for (ScriptEngineFactory factory : factories) {
      List<String> ext = factory.getExtensions();
      for (int i = 0; i < ext.size(); i++) {
        System.out.printf("Supported file extension: " + (String) ext.get(i) + "\n");
      }
    }
  }
}
