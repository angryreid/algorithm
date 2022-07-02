package emma;

import emma.tool.Asserts;
import emma.tool.Times;
import emma.union.*;

public class Main {
    private static int count = 100000;

    public static void testUnionFind(UnionFind uf) {
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(uf.isSame(0, 5));
        Asserts.test(!uf.isSame(0, 6));
    }

    public static void testUnionFindPerformance(UnionFind uf) {
        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count), (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count), (int)(Math.random() * count));
            }
        });
    }

    public static void main(String[] args) {
        testUnionFind(new QuickFind(12));
        testUnionFind(new QuickUnion(12));
        testUnionFind(new QuickUnionSize(12));
        testUnionFind(new QuickUnionRank(12));

        testUnionFindPerformance(new QuickFind(count));
        testUnionFindPerformance(new QuickUnion(count));
        testUnionFindPerformance(new QuickUnionSize(count));
        testUnionFindPerformance(new QuickUnionRank(count));
    }
}
