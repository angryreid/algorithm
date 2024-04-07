package emma.tree.morris;

import emma.tree.morris.printer.BinaryTreeInfo;
import emma.tree.morris.printer.BinaryTrees;

import java.util.Random;

public class TestMorris {
    public static class MorrisTree extends BinarySearchTree<Integer> {
        public void inOrder() {
            Node<Integer> node = root;
            while (node != null) {
                if (node.left != null) {
                    Node<Integer> pred = node.left;
                    while(pred.right != null && pred.right != node) {
                        pred = pred.right;
                    }
                    if(pred.right == null) {
                        pred.right = node;
                        node = node.left;
                    } else {
                        // pred.right == node
                        System.out.print(node.element + " ->");
                        pred.right = null;
                        node = node.right;
                    }
                } else {
                    System.out.print(node.element + " ->");
                    node = node.right;
                }
            }
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
