import java.util.Scanner;
import java.util.Comparator;
class Stockexc implements Comparable<Stockexc>{
	String name;
	float data;

	Stockexc(String p, float q) {
		this.name = p;
		this.data = q;
	}

	public String toString() {
		return this.name+" "+this.data;
	}

	public int compareTo(Stockexc that) {
		if (this.data > that.data) {
            return +1;
        }
        if (this.data < that.data) {
            return -1;
        }
        return this.name.compareTo(that.name);
    }
}

class Solution {
}
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

    public boolean isEmpty() {
        if (n != 0) {
            return false;
        }
        return true;
    }

    public void print() {
    	for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
            System.out.println(keys[i] + " " + values[i]);

            }
        }
    }
}
