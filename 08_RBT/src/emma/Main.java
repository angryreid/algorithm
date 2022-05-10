package emma;
import emma.tree.AVL;
import emma.printer.BinaryTrees;
import emma.tree.RBTree;

import java.util.Comparator;

public class Main {

    public static void add() {
        RBTree<Integer> rbTree = new RBTree<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });// Integer
        int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9, 7, 8, 1,2 };
        for (int num : treeArray) {
            System.out.println("Add:" + num);
            rbTree.add(num);
            BinaryTrees.println(rbTree);
            System.out.println("Added:" + num + "done");
        }
        BinaryTrees.println(rbTree);
    }

    public static void addAVLTest() {
        AVL<Integer> avl = new AVL<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });// Integer
        int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9, 7, 8, 1,2 };
        for (int num : treeArray) {
            avl.add(num);
        }
        BinaryTrees.println(avl);
    }

    public static void remove() {
        RBTree<Integer> rb = new RBTree<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });// Integer
        int[] treeArray = { 49, 97, 85, 5, 100, 15, 77, 16, 36, 99, 24, 79 };
        for (int num : treeArray) {
            rb.add(num);
        }
//        BinaryTrees.print(rb);
        System.out.println();
        rb.remove(49);
        BinaryTrees.print(rb);
    }
    public static void main(String[] args) {
//        addAVLTest();
//        add();
        remove();
    }
}
