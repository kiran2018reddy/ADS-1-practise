import java.util.Scanner;
/**
 * Class for stockexc.
 */
class Stockexc implements Comparable <Stockexc>{
    /**
     * { var_description }.
     */
    public String name;
    /**
     * { var_description }.
     */
    public float data;
/**
 * Constructs the object.
 *
 * @param      p     { parameter_description }.
 * @param      q     The quarter.
 */
    Stockexc(final String p, final float q) {
    this.name = p;
    this.data = q;
}
/**
 * Returns a string representation of the object.
 *
 * @return     String representation of the object.
 */
	public String toString() {
		return this.name + " " + this.data;
	}
/**
 * { function_description }.
 *
 * @param      that  The that.
 *
 * @return     { description_of_the_return_value }.
 */
	public int compareTo(final Stockexc that) {
		if (this.data > that.data) {
            return +1;
        }
        if (this.data < that.data) {
            return -1;
        }
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        STable<String, Integer> symbolMax = new STable<String, Integer>(30);
        STable<String, Integer> symbolMin = new STable<String, Integer>(30);

        for (int i = 0; i < 6; i++) {
            MinPQ<Stockexc> stMinPQ = new MinPQ<Stockexc>();
            MaxPQ<Stockexc> stMaxPQ = new MaxPQ<Stockexc>();
            for (int j = 0; j < n; j++) {
                String[] tokens = input.nextLine().split(",");
stMinPQ.insert(new Stockexc(tokens[0], Float.parseFloat(tokens[1])));
stMaxPQ.insert(new Stockexc(tokens[0], Float.parseFloat(tokens[1])));
            }
            for (int k = 0; k < 5; k++) {
                Stockexc a = stMaxPQ.deleteMax();
                System.out.println(a);
                symbolMax.put(a.name, 1);
            }
            System.out.println();
            for (int k = 0; k < 5; k++) {
                Stockexc b = stMinPQ.deleteMin();
                System.out.println(b);
                symbolMin.put(b.name, 1);
            }
            System.out.println();
        }

        int k = Integer.parseInt(input.nextLine());
        for (int i = 0; i < k; i++) {
            String[] tokens = input.nextLine().split(",");
            switch (tokens[0]) {
                case "get":
                if (tokens[1].equals("maxST")) {
                    System.out.println(symbolMax.get(tokens[2]));
                }
                if (tokens[1].equals("minST")) {
                    System.out.println(symbolMin.get(tokens[2]));
                }
            default:break;
      case "intersection":
        break;
            }
        }
    }
}
/**
 * Class for s table.
 *
 * @param      <Key>    The key.
 * @param      <Value>  The value.
 */
class STable<Key extends Comparable<Key>, Value> {
    /**
     * key array of type key.
     */
    private Key[] keys;
    /**
     * value array of value Type.
     */
    private int[] values;
    /**
     * size of the table.
     */
    private int n = 0;
    /**
     * Constructs the object.
     * The keys array of type Key.
     * The values array of type value.
     *
     * @param      size  The size of int type.
     */

    STable(final int size) {
        keys = (Key[]) new Comparable[size];
        values =  new int[size];
      }
/**
 * { function_description }.
 *
 * @param      key    The key.
 * @param      value  The value.
 */
    public void put(final Key key, final int value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i]++;
            return;
        }
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
/**
 * { function_description }.
 *
 * @param      key   The key.
 *
 * @return     { description_of_the_return_value }.
 */
    public int rank(final Key key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if     (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
/**
 * { function_description }.
 *
 * @param      key   The key.
 *
 * @return     { description_of_the_return_value }.
 */
    public int get(final Key key) {
        if (key == null) {
            System.out.println("No key");
            return 0;
        }
        if (isEmpty()) {
            return 0;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return 0;
    }
/**
 * Determines if empty.
 *
 * @return     True if empty, False otherwise.
 */
    public boolean isEmpty() {
        if (n != 0) {
            return false;
        }
        return true;
    }
/**
 * { function_description }.
 */
    public void print() {
    	for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
            System.out.println(keys[i] + " " + values[i]);

            }
        }
    }
}
