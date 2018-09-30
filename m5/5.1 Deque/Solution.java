import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * Variable first of node type.
     */
    private Node frst;
    /**
     * Variable last of node type.
     */
    private Node lst;
    /**
     * Variable size of int type.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Variable item of type integer}.
         */
        private int item;
        /**
         * {Variable next of type node}.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Deque() {
        this.frst = null;
        this.lst = null;
        this.size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Pushes a front.
     *
     * @param      num   The number
     */
    public void pushFront(final int num) {
        if (frst == null) {
            frst = new Node();
            frst.item = num;
            frst.next = null;
            lst = frst;
        } else {
            Node oldfirst = frst;
            frst = new Node();
            frst.item = num;
            frst.next = oldfirst;
        }
        size++;
    }
    /**
     * Method to push from back.
     *
     * @param      item1  The item 1
     */
    public void pushBack(final int item1) {
        if (lst == null) {
            lst = new Node();
            lst.item = item1;
            lst.next = null;
        } else {
            Node oldlast = lst;
            lst = new Node();
            lst.item = item1;
            lst.next = null;
            oldlast.next = lst;
        }
        size++;
    }
    /**
     * {Method to pop from front}.
     */
    public void popFront() {
        if (frst != null) {
            frst = frst.next;
            size--;
        }
    }
    /**
     * {Method to pop from back}.
     */
    public void popBack() {
        if (lst != null) {
            Node old = frst;
            while (old.next.next != null) {
                old = old.next;
            }
            old.next = null;
            lst = old;
            size--;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String str = "[";
            Node oldstr = frst;
            while (oldstr != null) {
                str += oldstr.item + ", ";
                oldstr = oldstr.next;
            }
            return str.substring(0, str.length() - 2) + "]";
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Deque d = new Deque();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
            case "size":
                int a = d.getSize();
                System.out.println(a);
                break;
            case "pushLeft":
                d.pushFront(Integer.parseInt(tokens[1]));
                System.out.println(d);
                break;
            case "pushRight":
                d.pushBack(Integer.parseInt(tokens[1]));
                System.out.println(d);
                break;
            case "popLeft":
                if (!(d.isEmpty())) {
                    d.popFront();
                    System.out.println(d);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!(d.isEmpty())) {
                    d.popBack();
                    System.out.println(d);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            default:
                break;
            }
        }
    }
}
