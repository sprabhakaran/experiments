import java.util.*;
class MemoryLeaks {
   private static List<Double> memoryLeakList = new ArrayList<Double>();
   public static void main(String[] args){
      double d = 0.0;
      while(true){
         Double dbl = new Double(d);
         memoryLeakList.add(dbl);
         d++;
      }
   }

}
