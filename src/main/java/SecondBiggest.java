import com.google.common.primitives.Ints;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SecondBiggest {

//    Given an array of ints, return second biggest element of the array (index and value).

    public static void main(String[] args) {
        int[] arr = {1,9,9,9,7,7,8,6,5,4,10,3,10,2,4,5,6,7,8};
        int max = arr[0];
        int max2 = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > max){
              max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max2 && arr[i] != max){
                max2 = arr[i];
            }
        }
        System.out.println(max2);
        System.out.println(Ints.indexOf(arr,max2));
    }
}

