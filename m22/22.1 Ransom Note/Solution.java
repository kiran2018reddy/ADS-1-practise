import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // Unused constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> k;
        k = new SeparateChainingHashST<String, Integer>();
        String tokens = scan.nextLine();
        String[] magazine = scan.nextLine().split(" ");
        for (int i = 0; i < magazine.length; i++) {
            if (k.contains(magazine[i])) {
                k.put(magazine[i], k.get(magazine[i]) + 1);
            } else {
                k.put(magazine[i], 1);
            }
        }
        String[] tobeSearched = scan.nextLine().split(" ");
        for (int i = 0; i < tobeSearched.length; i++) {
            if (k.contains(tobeSearched[i])) {
                if (k.get(tobeSearched[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    k.put(
                        tobeSearched[i], k.get(tobeSearched[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
