package emma.union;

public class QuickUnionRankPathCompress extends QuickUnionRank {
    public QuickUnionRankPathCompress(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        if (parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
