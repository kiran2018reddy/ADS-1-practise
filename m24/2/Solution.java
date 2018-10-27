import util.java.scanner;
class BinaryST<RollNum, StudentName, Marks> {
    private int size;
    BinaryST() {

    }
    private Node root;
    class Node {

        private Integer roll;

        private Name name;

        private Double marks;
        private Node left;

        private Node right;

        private int size;

        Node(final Integer k, final Name v, final Double m, final int s) {
            this.roll = k;
            this.name = v;
            this.marks = m;
            this.left = null;
            this.right =  null;
            this.size = s;
        }
    }
}


    public void put(final Integer roll, final Name name, final Double mark) {
        if (roll == null) {
            return;
        }
        root = put(root, roll, name, mark);
    }

    private Node put(final Node x, final Integer roll, final Name name, final Double mark) {
        size++;
        if (x == null) {
            return new Node(roll, name, mark, 1);
        }
        int cmp = roll - x.roll;
        if (cmp < 0) {
            x.left  = put(x.left,  roll, name, mark);
        } else if (cmp > 0) {
            x.right = put(x.right, roll, name, mark);
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;


    }
    public int size() {
        return size(root);
    }
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
