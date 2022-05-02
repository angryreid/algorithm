package emma;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
  private int size;
  Node<E> root;
  private Comparator<E> comparator;
  private ArrayList<E> traversalOrderList = new ArrayList<E>(100);

  public BinarySearchTree(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  public BinarySearchTree() {
    this(null);
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return false;
  }

  public void clear() {

  }

  public void add(E element) {
    checkElementNull(element);

    if (root == null) { // first node
      root = new Node<E>(element, null);
      size++;
      return;
    }

    // Add othre node
    // find parent
    Node<E> parent = null;
    Node<E> node = root;

    // compere
    int compareRes = 0;
    while (node != null) {
      compareRes = compare(element, node.element);
      parent = node;
      if (compareRes > 0) {
        node = node.right;
      } else if (compareRes < 0) {
        node = node.left;
      } else { // equals
        node.element = element;// Cover
        return;
      }
    }

    // add to parent's left or right
    Node<E> newNode = new Node<>(element, parent);
    if (compareRes > 0) {
      parent.right = newNode;
    } else {
      parent.left = newNode;
    }
    size++;
  }

  /**
   * 
   * @param el1
   * @param el2
   * @return 0 el1 == el2 > 0 el1 > el2 < 0 el1 < el2
   */
  private int compare(E el1, E el2) {//
    if (comparator != null) {
      return comparator.compare(el1, el2);
    }
    return ((java.lang.Comparable<E>) el1).compareTo(el2);
  }

  public void remove(E element) {
    remove(findNode(element));
  }

  private void remove(Node<E> node) {
    if (node == null) return;
    size--;
    if (node.fullLeaf()) {

    }
  }

  private Node<E> findNode(E element) {
    Node<E> node = root;
    while (node != null) {
      if (node.element == element) return node;
      int compareRes = compare(node.element, element);
      if (compareRes > 0)
        node = node.left;
      else
        node = node.right;
    }
    return null;
  }

  /**
   * The pre node by inorder.
   * @param node
   * @return
   */
  private Node<E> predecessor(Node<E> node) {
    if (node == null) return null;
    Node<E> p = node.left;
    if (p != null) {
      while (p.right != null) {
        p = p.right;
      }
      return p;
    }
//    if (node.left == null && node.parent != null) {
//      preNode = node.parent;
//      while (compare(preNode.element, node.element) > 0) {
//        preNode = preNode.parent;
//        if (preNode == null) return null;
//      }
//    }
    while (node.parent != null && node == node.parent.left) {
      node = node.parent;
    }
    return node.parent;
  }

  private Node<E> subdecessor(Node<E> node) {
    if (node == null) return null;
    Node<E> s = node.right;
    if (s != null) {
      while (s.left != null) {
        s = s.left;
      }
      return s;
    }
//    if (susNode == null && node.parent != null) {
//      susNode = node.parent;
//      while (compare(susNode.element, node.element) < 0) {
//        susNode = susNode.parent;
//        if (susNode == null) return null;
//      }
//    }
    while (node.parent != null && node == node.parent.right) {
      node = node.parent;
    }
    return node.parent;
  }

  public E getRootPredecessor() {
    return predecessor(root).element;
  }

  public E getPredesessor(E element) {
    Node<E> p = predecessor(findNode(element));
    if (p != null) {
      return p.element;
    } else {
      return null;
    }
  }

  public E getRootSubdecessor() {
    return subdecessor(root).element;
  }

  public E getSubdesessor(E element) {
    Node<E> s = subdecessor(findNode(element));
    if (s != null) {
      return s.element;
    } else {
      return null;
    }
  }

  public boolean contains(E elemenet) {
    return false;
  }

  private void checkElementNull(E element) {
    if (element == null) {
      throw new IllegalArgumentException("element must not be null");
    }
  }

  public void preorderTraversal() {
    traversalOrderList.clear();
    preorderTraversal(root);
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

  public String toString() {
    StringBuilder sb = new StringBuilder();
    toString(root, sb, "");
    return sb.toString();
  }

  public void toString(Node<E> node,StringBuilder sb, String prefix) {
    if(node == null) return;
//    sb.append(prefix).append(node.element).append("\n");
    toString(node.left, sb, prefix + "L---");
    sb.append(prefix).append(node.element).append("\n"); // Inorder of BST is sorted
    toString(node.right, sb, prefix + "R---");
  }

  /**
   * preorder traversal.
   * 
   * @param node
   */
  private void preorderTraversal(Node<E> node) {
    if (node == null)
      return;
    // System.out.println(node.element);
    traversalOrderList.add(node.element);
    preorderTraversal(node.left);
    preorderTraversal(node.right);
  }

  public void inorderTraversal() {
    traversalOrderList.clear();
    inorderTraversal(root);
  }

  /**
   * inorder traversal
   * 
   * @param node
   */
  private void inorderTraversal(Node<E> node) {
    if (node == null)
      return;
    inorderTraversal(node.left);
    traversalOrderList.add(node.element);
    inorderTraversal(node.right);
  }

  public void accessPostorderTraversal(Accessor<E> accessor) {
    traversalOrderList.clear();
    postorderTraversal(root, accessor);
  }

  /**
   * postorder traversal
   * 
   * @param node
   */
  private void postorderTraversal(Node<E> node, Accessor<E> accessor) {
    if (node == null || accessor.stop)
      return;
    postorderTraversal(node.left, accessor);
    postorderTraversal(node.right, accessor);
    if (accessor.stop) return;
    accessor.stop = accessor.access(node.element);
    traversalOrderList.add(node.element);
  }

  public void postorderVisit(Visitor<E> visitor) {
    if (visitor == null) return;
    postorderVisitPrint(root, visitor);
  }

  private void postorderVisitPrint(Node<E> node, Visitor<E> visitor) {
    if (node == null || visitor.stop) return;
    postorderVisitPrint(node.left, visitor);
    postorderVisitPrint(node.right, visitor);
    if(visitor.stop) return;
    visitor.stop = visitor.visit(node.element);
  }


  public void levelOrderTraversal() {
    traversalOrderList.clear();
//    levelOrderTraversal(root);
  }

  /**
   * level-order traversal
   * 
   * @param accessor
   */
  public void levelOrderTraversal(Accessor<E> accessor) {
    Queue<Node<E>> queue = new LinkedList<Node<E>>();
    queue.offer(root); // enQueue
    while (!queue.isEmpty()) {
      Node<E> cNode = queue.poll();
//      traversalOrderList.add(cNode.element);
      accessor.access(cNode.element);
      if (cNode.left != null)
        queue.offer(cNode.left);
      if (cNode.right != null)
        queue.offer(cNode.right);
    }
  }

//  public boolean isComplete() {
//    Queue<Node<E>> queue = new LinkedList<Node<E>>();
//    queue.offer(root);
//
//    boolean foundLeaf = false;
//    while (queue.isEmpty()) {
//      Node<E> node = queue.poll();
//      if (foundLeaf && !node.isLeaf()) return false;
//
//      if (node.fullLeaf()) {
//        queue.offer(node.left);
//        queue.offer(node.right);
//      } else if (node.left == null && node.right != null) {
//        return false;
//      } else {
//        foundLeaf = true;
//        if (node.left != null) {
//          queue.offer(node.left);// fix
//        }
//      }
//    }
//    return true;
//  }

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

  public void showTravelOrder() {
    System.out.println(traversalOrderList.toString());
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
//      traversalOrderList.add(cNode.element);
//      accessor.access(cNode.element);
      if (cNode.left != null)
        queue.offer(cNode.left);
      if (cNode.right != null)
        queue.offer(cNode.right);
    }
  }

  /**
   *
   * @param <E>
   *     abstract class can declare variable
   */
  public static abstract class Visitor<E> {
    boolean stop;
    abstract boolean visit(E element);
  }

  private static class Node<E> {
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

  public static abstract class Accessor<E> {// Accessor，Customized data after getting
    boolean stop;
    abstract boolean access(E el);
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
}
