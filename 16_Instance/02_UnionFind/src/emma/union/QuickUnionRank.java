package emma.union;

public class QuickUnionRank extends QuickUnion {
    private int[] ranks;
    public QuickUnionRank(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    /**
     * Moved the small rank union to the large rank union
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        if(ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p2] < ranks[p1]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2]++;
        }
    }
}
