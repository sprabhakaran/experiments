import javax.swing.JOptionPane;
class School
{
   public static void main (String [] args)
   {
      String mark;
      int convert;
      int score[] = new int [6];
      for(int i=0; i<score.length; i++)
      {

         {

            String numString = JOptionPane.showInputDialog(null,"Please enter    marks:","User Input",JOptionPane.QUESTION_MESSAGE);
            System.out.println("Num String ::: " + numString);
            score[i] = Integer.parseInt(numString);
         }
         int max = score[0];
         for(int j=0; j<score.length; j++)
         {
            if(max<score[j])
               max=score[j];
         }

         String output="The array is:";
         for(int k=0; k<score.length; k++)
         {
            output=output+score[k]+"";
         }
         output=output+"\nThe largest number is"+max;
         //output=output+"\nThe occurence of the largest number is"+count;
         JOptionPane.showMessageDialog(null,output,"Output",JOptionPane.INFORMATION_MESSAGE);
      }
   }
}

