// import java.util.Scanner;
// import java.util.Arrays
// class Solution {
//     private int[] arr;
//     private int n;
//     protected Solution() {
//         arr = new int[n];
//     }
//     public int size() {
//         return n;
//     }
//     public int[] array() {
//         return arr;
//     }
//     public static void trSum(final int[] array) {
//         Arrays.sort(array);
//         int count = 0;
//     for (int i = 0; i < length - 1; i++) {
//             int j = i + 1;
//             int k = length - 1;
//             //int x = arr[i];
//             while (j < r) {
//                 int sum = arr[i] + arr[j]+arr[r];
//                 if (sum == 0) {
//                     count++;
//                     j++;
//                     r--;
//                 } else if (sum < 0) {
//                     j++;
//                 }else {
//                     r--;
//                 }
//             }
//         }
//         System.out.println(count);
//     }
// }

        // for (int i = 0; i < array.length; i++) {
        //     for (int j = i + 1; j < array.length ; j++) {
        //         for (int k = array.length-1; k > j; k--) {
        //         if (array[i] + array[j] + array[k] == 0) {
        //             count++;
                    // System.out.println(count);
                    // break;
    //             }
    //         }
    //     }
    // }
    //    System.out.println(count);
    // }
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for three sum.
 */
final class ThreeSum {
    /**
     * { var_description }.
     */
    private int count = 0;
    /**
     * { function_description }.
     *
     * @param      arr   The arr.
     */
    void findTriple(final int[]arr) {
        //int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            //int x = arr[i];
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    count++;
                    j++;
                    k--; //incresing j i.e k should be less than prious k or  k = arr.length - 1;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        System.out.println(count);
    }
}
/**
 * Class for solution.
 */
 final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        ThreeSum t = new ThreeSum();
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        t.findTriple(arr);
    }
}
