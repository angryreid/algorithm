package emma.union;

public class QuickUnionRankPathHalf extends QuickUnionRank {
    public QuickUnionRankPathHalf(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }
}
