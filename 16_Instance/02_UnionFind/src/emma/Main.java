package emma;

import emma.model.Student;
import emma.tool.Asserts;
import emma.tool.Times;
import emma.union.*;

public class Main {
    private static int count = 10000;

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
        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count), (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count), (int)(Math.random() * count));
            }
        });
    }

    public static void testGenericUnionFind(GenericUnionFind<Integer> uf) {
        for (int i = 0; i < count; i++) {
            uf.makeSet(i);
        }
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
//        testUnionFind(new QuickFind(count));
//        testUnionFind(new QuickUnion(count));
//        testUnionFind(new QuickUnionSize(count));
//        testUnionFind(new QuickUnionRank(count));
//        testUnionFind(new QuickUnionRankPathCompress(count));
//        testUnionFind(new QuickUnionRankPathSplit(count));
//        testUnionFind(new QuickUnionRankPathHalf(count));
        testGenericUnionFind(new GenericUnionFind<Integer>());
        GenericUnionFind<Student> guf = new GenericUnionFind<>();
        Student nick = new Student(16, "Nick");
        Student emma = new Student(15, "Emma");
        Student jack = new Student(17, "Jack");
        Student rose = new Student(18, "Rose");
        guf.makeSet(nick);
        guf.makeSet(emma);
        guf.makeSet(rose);
        guf.makeSet(jack);

        guf.union(nick, emma);
        guf.union(jack, rose);
        guf.union(emma, rose);
        Asserts.test(guf.isSame(nick, emma));
        Asserts.test(guf.isSame(jack, rose));
        Asserts.test(guf.isSame(nick, jack));
    }
}
