import javax.script.*;
import java.io.*;
public class ScriptVars { 
  public static void main(String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    File f = new File("test.txt");
    engine.put("file", f);

    engine.eval("print(file.getAbsolutePath())");
  }
}
