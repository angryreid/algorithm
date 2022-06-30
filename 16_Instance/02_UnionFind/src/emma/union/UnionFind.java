package emma.union;

public abstract class UnionFind {
    protected int[] parents;

    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must greater then zero");
        }
        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    /**
     * Find data set of v
     * @param v
     * @return
     */
    public abstract int find(int v);

    /**
     * Check if v1 & v2 belong to the same data set
     * @param v1
     * @param v2
     * @return
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /**
     * Union data set of v1 & v2
     * @param v1
     * @param v2
     */
    public abstract void union(int v1, int v2);

    protected void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("Parameter is out of bounds");
        }
    }

}
