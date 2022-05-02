package emma;

import printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E>  implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;

    /**
     * abstract class can declare variable
     */
    public static abstract class Visitor<E> {
        boolean stop;
        abstract boolean visit(E element);
    }

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean fullLeaf() {
            return left != null && right != null;
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
//    return myNode.element + "_p(" + parentString + ")";
        return myNode.element;
    }

    public boolean contains(E elemenet) {
        return false;
    }

    public int height() {
        return height(root);
    }

    public int height(Node<E> node) {
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) +  1;
    }

    public int heightLevel() {
        if(root == null) return 0;
        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        queue.offer(root); // enQueue
        while (!queue.isEmpty()) {
            int length = queue.size();
            levelSize--;
            Node<E> cNode = queue.poll();

            if (cNode.left != null)
                queue.offer(cNode.left);
            if (cNode.right != null)
                queue.offer(cNode.right);
            if (levelSize == 0) {
                height += 1 ;
                levelSize = queue.size();
            }
        }
        return height;
    }

    public boolean isComplete() {
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        queue.offer(root);
        boolean foundLeaf = false;
        while (queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (!node.isLeaf() && foundLeaf) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                // node.left == null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                // node.left == null && node.right == null
                // node.left != null && node.rgiht == null
                foundLeaf = true;
            }
        }
        return true;
    }

    /**
     * The pre node by inorder.
     * if the child number of a node is 2. then the child number of it's predecessor
     * or susdecessor must be 0 or 1.
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    protected Node<E> subdecessor(Node<E> node) {
        if (node == null) return null;
        Node<E> s = node.right;
        if (s != null) {
            while (s.left != null) {
                s = s.left;
            }
            return s;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    public void preorder(Visitor<E> visitor) {
        if (visitor == null) return;
        preorderVisit(root, visitor);
    }
   
    private void preorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        visitor.stop = visitor.visit(node.element);
        preorderVisit(node.left, visitor);
        preorderVisit(node.right, visitor);
    }

    public void inorder(Visitor<E> visitor) {
        if (visitor == null) return;
        inorderVisit(root, visitor);
    }
    
    private void inorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        inorderVisit(node.left, visitor);
        if(visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorderVisit(node.right, visitor);
    }

    public void postorder(Visitor<E> visitor) {
        if (visitor == null) return;
        postorderVisit(root, visitor);
    }

    public void postorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        postorderVisit(node.left, visitor);
        postorderVisit(node.right, visitor);
        if(visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    public void levelVisit(Visitor<E> visitor) {
        if (root == null || visitor == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        queue.offer(root); // enQueue
        while (!queue.isEmpty()) {
            Node<E> cNode = queue.poll();
            visitor.visit(cNode.element);
            if (cNode.left != null)
                queue.offer(cNode.left);
            if (cNode.right != null)
                queue.offer(cNode.right);
        }
    }
}
