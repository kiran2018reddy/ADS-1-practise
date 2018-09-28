import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int s1 = Integer.parseInt(s.nextLine());
        int s2 = Integer.parseInt(s.nextLine());
        int[] arr1 = new int[s1];
        int[] arr2 = new int[s2];
        String[] str1 = s.nextLine().split(",");
        String[] str2 = s.nextLine().split(",");
        for (int i = 0; i < s1; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }
        for (int i = 0; i < s2; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr3 = new int[s1 + s2];
        while (k < s1 + s2) {
            if ((i < s1) && (j < s2)) {
                if (arr1[i] < arr2[j]) {
                    arr3[k] = arr1[i];
                    i++;
                    k++;
                } else if (arr1[i] > arr2[j]) {
                    arr3[k] = arr2[j];
                    j++;
                    k++;
                } else {
                    arr3[k] = arr1[i];
                    i++;
                    k++;
                    arr3[k] = arr2[j];
                    j++;
                    k++;
                }
            } else {
                break;
            }
        }
            if (i < s1) {
                while (i < s1) {
                    arr3[k] = arr1[i];
                    i++;
                    k++;
                }
            }
            if (j < s2) {
                while (j < s2) {
                    arr3[k] = arr2[j];
                    j++;
                    k++;
                }
            }
        for (int x = 0; x < arr3.length - 1; x++) {
            System.out.print(arr3[x] + ",");
        }
        System.out.println(arr3[arr3.length - 1]);
    }
}
