public class Assignment {
   public static void main(String[] a){
      int count = 0;
      for (int i = 0; i < 3; i++)
         count += count++;
      System.out.println(count);
   }
}
