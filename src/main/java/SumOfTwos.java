public class SumOfTwos {
//    Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
//    sum28([2, 3, 2, 2, 4, 2]) → true
//    sum28([2, 3, 2, 2, 4, 2, 2]) → false
//    sum28([1, 2, 3, 4]) → false

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 2, 4, 2};
        int count = 0;
        for (int j : arr) {
            if (j == 2) {
                count = count + j;
            }
        }
        System.out.println(count == 8);
    }
}
