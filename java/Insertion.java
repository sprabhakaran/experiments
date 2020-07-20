import java.util.Arrays;
public class Insertion{
    
    public static void main(String arg[]){
        int[] arr = {1,2,3,4,573,3,2,7,43,32};
        for (int i=1; i<arr.length; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]){
                int tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j]=tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
