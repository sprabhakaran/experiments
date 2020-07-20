import javax.tools.*;
public class SimpleCompileTest 
{
   public static void main(String[] args) 
   {
      String fileToCompile = "C.txt";
      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      System.out.println(compiler.getSourceVersions());
      int compilationResult = compiler.run(null, null, null, fileToCompile);
      if(compilationResult == 0){
         System.out.println("Compilation is successful");
      }else{
         System.out.println("Compilation Failed");
      }
   }
}

