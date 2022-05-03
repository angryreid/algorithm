package emma;
import emma.tree.BST;
import emma.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    public static void remove() {
        BST<Integer> bst = new BST<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });// Integer
        int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9, 7, 8 };
        for (int num : treeArray) {
            bst.add(num);
        }
        BinaryTrees.print(bst);
        System.out.println();
        System.out.println("removed");
        System.out.println();
        bst.remove(24);
        BinaryTrees.print(bst);
    }
    public static void main(String[] args) {
        remove();
    }
}
