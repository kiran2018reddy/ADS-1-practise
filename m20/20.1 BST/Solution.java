import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
     /**
     * Name of book.
     */
    private String name;
    /**
     * author of book.
     */
    private String author;
    /**
     * price of book.
     */
    private float price;

    /**
     * Constructs the object.
     *
     * @param      n     { String n }
     * @param      a     { String a }
     * @param      p     { String p }
     */

    Book(final String n, final String a, final float p) {
        this.name = n;
        this.author = a;
        this.price = p;
    }
    /**
     * Gets the name.
     * The time complexity is O(1).
     *
     * @return     The name of string type.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Gets the author.
     * The time complexity is O(1).
     *
     *
     * @return     The author of string type.
     */

    public String getAuthor() {
        return this.author;
    }

    /**
     * Gets the price.
     * The time complexity is O(1).
     *
     * @return     The price of int type.
     */

    public float getPrice() {
        return this.price;
    }
    /**
     * compares two names of the authors.
     * The time complexity is O(1).
     *
     * @param      that  The that of Book class
     *
     * @return     { int }
     */

    public int compareTo(final Book that) {
        return this.name.compareTo(that.name);
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
     * main method. reads input.
     * The time complexity is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        Scanner input = new Scanner(System.in);
        BinarySearchTree<Book, Integer>
        binarySearch = new
        BinarySearchTree<Book, Integer>();
        while (input.hasNext()) {
            String[] tokens = input.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                Book key = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                Integer value = Integer.parseInt(tokens[four]);
                binarySearch.put(key, value);
                break;
                case "get":
                Book key1 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                System.out.println(binarySearch.get(key1));
                break;
                case "max":
                Book key2 = binarySearch.max();
                binarySearch.toString(key2);
                break;
                case "min":
                Book key3 = binarySearch.min();
                binarySearch.toString(key3);
                break;
                case "floor":
                Book key4 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.toString(binarySearch.floor(key4));
                break;
                case "ceiling":
                Book key5 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.toString(binarySearch.ceiling(key5));
                break;
                case "select":
                binarySearch.toString(binarySearch.select(
                    Integer.parseInt(tokens[1])));
                break;
                case "deleteMin":
                binarySearch.deleteMin();
                break;
                case "deleteMax":
                binarySearch.deleteMax();
                break;
                case "delete":
                Book key6 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.delete(key6);

                default:
                break;

            }
        }
    }
}

/**
 * Class for binary search tree.
 *
 * @param      <E>      { Generic type }
 * @param      <Value>  Integer type
 */
class BinarySearchTree<E extends Comparable<E>, Value> {
    /**
     * size of the tree.
     */
    private int size;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {

    }

/**
 * root of node type.
 */
    private Node root;
    /**
     * Class for node.
     * Node class has a key, value.
     * left node address.
     * right node address.
     */
    class Node {
        /**
         * key of node.
         */
        private E key;
        /**
         * value of node.
         */
        private Value value;
        /**
         * left node address.
         */
        private Node left;
        /**
         * right node address.
         */
        private Node right;
        /**
         * sizeof tree.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      k    The key of Bookkey class.
         * @param      v  The value of int type.
         * @param      s  The size.
         */
        Node(final E k, final Value v, final int s) {
            this.key = k;
            this.value = v;
            this.left = null;
            this.right =  null;
            this.size = s;
        }

    }
    /**
     * puts the value in trees.
     * The time complexity is O(N).
     *
     * @param      key   The key of Bookkey class.
     * @param      val   The value of int type.
     */

     public void put(final E key, final Value val) {
        if (key == null) {
            return;
        }
        root = put(root, key, val);
    }
    /**
     * puts the keys and values.
     * overloaded method.
     * The time complexity is O(N).
     * The binary search looks for half of the values.
     *
     * @param      x     { NODE TYPE }
     * @param      key   The key of bookkey.
     * @param      val   The value of int type.
     *
     * @return     { returns node type. That becomes root }
     */

    private Node put(final Node x, final E key, final Value val) {
        size++;
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.value = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     *
     * get method for that particular key.
     * The time complexity is O(N) -- worst case.
     *
     * @param      key   The key if bookkey class.
     *
     * @return     { returns int }
     */

    public Value get(final E key) {
        return get(root, key);
    }

    /**
     * gets the key.
     * overloaded method.
     * The time complexity is O(N).
     * The traversal is only for logN times.
     *
     * @param      x     { Node x - root node }
     * @param      key   The key of bookkey class
     *
     * @return     { returns int }
     */

    private Value get(final Node x, final E key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
             return x.value;
        }
    }

    /**
     * method to find maximum element in binary tree.
     * The time complexity is O(N).
     *
     * @return     { book object of book class }
     */
     public E max() {

        return max(root).key;
    }

    /**
     * The maximum node is found.
     * The time complexity is O(N).
     *
     *
     * @param      x     { Node type }
     *
     * @return     { returns maximum node}
     */

    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * The minimum node is found.
     * The time complexity is O(N).
     *
     *
     * @return     {book class }
     */

    public E min() {

        return min(root).key;
    }
    /**
     * The minimum node is found.
     * The time complexity is O(N).
     *
     *
     * @param      x     { Node class }
     *
     * @return     { Node type }
     */

    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * Returns the largest key in the symbol table.
     * less than or equal to key.
     * The time complexity is O(N).
     *
     *
     * @param      key   The key of book class
     *
     * @return     { returns book type }
     */

    public E floor(final E key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    /**
     * returns less or equal to key.
     * The time complexity is O(N).
     *
     *
     * @param      x     { Node type }
     * @param      key   The key
     *
     * @return     { returns node }
     */

    private Node floor(final Node x, final E key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * returns greater than or equal to key.
     * The time complexity is O(N).
     *
     *
     * @param      key   The key of book class type.
     *
     * @return     { returns book type }
     */

    public E ceiling(final E key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * returns greater than or equal to value.
     * The time complexity is O(N).
     *
     *
     * @param      x     { Node type }
     * @param      key   The key of book type.
     *
     * @return     { returns node }
     */

    private Node ceiling(final Node x, final E key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * returns value at given index.
     * The time complexity is O(N).
     *
     *
     * @param      k     { integer k }
     *
     * @return     { book class }
     */

    public E select(final int k) {

        Node x = select(root, k);
        return x.key;
    }
    /**
     * { returns node of the select integer }
     * The time complexity is O(N).
     *
     *
     * @param      x     { Node type }
     * @param      k     { integer }
     *
     * @return     { Node type }
     */

    private Node select(final Node x, final int k) {
        if (x == null) {
         return null;
        }
        int t = size(x.left);
        if      (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * size of the binary tree.
     * The time complexity is O(1).
     *
     *
     * @return     { int type }
     */

    public int size() {
        return size(root);
    }

    /**
     * return number of key-value pairs in BST rooted at x.
     * The time complexity is O(1).
     *
     *
     * @param      x     { Node type }
     *
     * @return     { int type }
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * deletes the minimum element.
     * The tome complexity is O(N) -- worst case.
     */

    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * returns minimum element and replaces null with it.
     * The tome complexity is O(N) -- worst case.
     *
     *
     * @param      x     { Node type }
     *
     * @return     { Node type }
     */

    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * deletes maximum element.
     * The tome complexity is O(N) -- worst case.
     *
     */

    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * deletes maximum element.
     * The tome complexity is O(N) -- worst case.
     *
     *
     * @param      x     { Node type }
     *
     * @return     { Node type }
     */

    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * deletes the particular key.
     * The tome complexity is O(N) -- worst case.
     *
     * @param      key   of book class type.
     */

    public void delete(final E key) {
        root = delete(root, key);
    }
    /**
     * The method deletes the given key.
     * The tome complexity is O(N) -- worst case.
     *
     *
     * @param      x     { Node type }
     * @param      key   key of book class type to be deleted.
     *
     * @return     { Node type }
     */

    private Node delete(final Node x, final E key) {
        Node temp = x;
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = delete(x.left,  key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left  == null) {
                return x.right;
            }
            Node t = x;
            temp = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * prints the book class.
     * The time complexity is O(1).
     *
     *
     * @param      book  The book
     */

    public void toString(final Book book) {
        if (book == null) {
            System.out.println("null");
        } else {
        System.out.println(book.getName() + ", "
            + book.getAuthor() + ", " + book.getPrice());
        }

    }

}
