public class Min
{
  public static void main(String arg[])
  {
    int[] numArr = {3,4,2,5,6,7,8,2,5,1,4,4,6};
    int min = numArr[0];

    for(int i=1; i<numArr.length; i++)
    {
      if(min > numArr[i])
      {
        min = numArr[i];
      }
    }
    System.out.println(min);
  }
}
