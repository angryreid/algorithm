package emma.tree.morris;

import emma.tree.morris.printer.BinaryTreeInfo;
import emma.tree.morris.printer.BinaryTrees;

import java.util.Random;

public class TestMorris {
    public static class MorrisTree extends BinarySearchTree<Integer> {
        public void inOrder() {
            inOrder(root);
        }

        public void inOrder(Node<Integer> node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(node.element + " ->");
            inOrder(node.right);
        }
    }
    public static void main(String[] args) {
        MorrisTree tree = new MorrisTree();
        for (int i = 0; i < 10; i++) {
            tree.add(new Random().nextInt(100));
        }
        BinaryTrees.println(tree);
        System.out.println("--------------");
        tree.inOrder();
        System.out.println("--------------");
        BinaryTrees.println(tree);
    }
}
