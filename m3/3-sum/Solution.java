import java.util.Scanner;
import java.util.Arrays;

class Solution {
  
    private int[] arr;
 
    private int n;
  
    protected Solution() {
        arr = new int[n];
    }
  
    public int size() {
        return n;
    }
 
    public int[] array() {
        return arr;
    }
    public static void trSum(final int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                for (int k = array.length-1; k > j; k--) {
                if (array[i] + array[j] + array[k] == 0) {
                    count++;
                    break;
                }
            }
        }
    }
       System.out.println(count);
    }
     public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        int[] arr = new int[inp];
        for (int i = 0; i < inp; i++) {
            arr[i] = sc.nextInt();
        }
        trSum(arr);
    }
}


// import java.util.Scanner;
// import java.util.Arrays;
// class Solution {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         threeSum t = new threeSum();
//         int n = s.nextInt();
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = s.nextInt();
//         }
//         t.findTrip(arr);
//         // System.out.println(t.Binarysearch(arr, 6));
//         // System.out.println(Arrays.toString(arr));
//     }
// }
// class threeSum {
//     int count;
//     threeSum() {
//         count = 0;
//     }
//     void findTrip(int[]arr) {
//         int len = arr.length;
//         Arrays.sort(arr);
//         for (int i = 0; i < len - 1; i++) {
//             int j = i + 1;
//             int r = len - 1;
//             int x = arr[i];
//             while (j < r) {
//                 int sum = x + arr[j]+arr[r];
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
