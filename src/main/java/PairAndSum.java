import java.util.Arrays;

public class PairAndSum {
    // Find a pair of elements from an array whose sum equals a given number
    public static void main(String[] args) {

        int[] arr = {6,8,3,4,9,0,7};
        int sum = 11;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum ){
                    int[] pair = {arr[i], arr[j]};
                    System.out.println(Arrays.toString(pair));
                }
            }
        }
    }
}
