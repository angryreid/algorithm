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

  public void postorderTraversal() {
    traversalOrderList.clear();
    postorderTraversal(root);
  }

  /**
   * postorder traversal
   * 
   * @param node
   */
  private void postorderTraversal(Node<E> node) {
    if (node == null)
      return;
    postorderTraversal(node.left);
    postorderTraversal(node.right);
    traversalOrderList.add(node.element);
  }

  public void levelOrderTraversal() {
    traversalOrderList.clear();
//    levelOrderTraversal(root);
  }

  /**
   * level-order traversal
   * 
   * @param node
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

  public void showTravelOrder() {
    System.out.println(traversalOrderList.toString());
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
  }

  public static interface Accessor<E> {// Accessor，Customized data after getting
    void access(E el);
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
