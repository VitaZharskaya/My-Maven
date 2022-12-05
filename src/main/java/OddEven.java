import java.util.ArrayList;
import java.util.Arrays;

public class OddEven {
//    Дан массив чисел. Сделать новый массив где сначала идут четные числа, потом нечетные

    public static int[] numbers (int[] evenOdd){

        int[] newArr = new int[evenOdd.length];
        int j = 0, k = 0;
        for (int i = 0; i < newArr.length; i++) {
            if (evenOdd[i] % 2 == 0) {
                newArr[j] = evenOdd[i];
                j++;
            }else{
                newArr[evenOdd.length-k-1] =  evenOdd[i];
                    k++;
                }
            }

       return newArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numbers(new int[]{2,1,3,4,5,6,7,6,8,7,7,6,5,4})));
    }
}
