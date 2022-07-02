package emma.union;

public class QuickUnionRankPathSplit extends QuickUnionRank {
    public QuickUnionRankPathSplit(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            // v = parents[v];
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return v;
    }
}