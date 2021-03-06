class MinPQ<Key> {

	Key[] pq;
	int n;
    Comparator<Key> comparator;


	MinPQ() {
    this(1);
    }

	MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    MinPQ(final int initCapacity, final Comparator<Key> comparat) {
        this.comparator = comparat;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    MinPQ(final Comparator<Key> comparato) {
        this(1, comparato);
    }

    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(final Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }

    public Key deleteMin() {
        final int four = 4;
        Key min = pq[1];
        exchange(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) resize(pq.length / 2);
        return min;
    }

    private void swim(final int key) {
        int k = key;
        while (k > 1 && greater(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(final int key) {
        int k = key;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

     private void exchange(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}