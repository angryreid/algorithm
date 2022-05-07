package emma;
import emma.tree.AVL;
import emma.printer.BinaryTrees;

import java.util.Comparator;

public class Main {

    public static void show() {
        AVL<Integer> avl = new AVL<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });// Integer
        int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9, 7, 8, 1,2 };
        for (int num : treeArray) {
//            System.out.println("Add: " + num);
            avl.add(num);
//            BinaryTrees.println(avl);
//            System.out.println("--------------Divider----------------");
        }
        BinaryTrees.println(avl);
    }

    public static void remove() {
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
//        BinaryTrees.print(avl);
//        System.out.println();
//        System.out.println("removed");
        System.out.println();
        avl.remove(74);
        BinaryTrees.print(avl);
    }
    public static void main(String[] args) {
        remove();
//        show();
    }
}
