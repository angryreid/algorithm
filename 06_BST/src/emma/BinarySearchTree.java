package emma;

import java.util.Comparator;

public class BinarySearchTree<E> {
  private int size;
  Node<E> root;
  private Comparator<E> comparator;

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
    if(comparator != null) {
      return comparator.compare(el1, el2);
    }
    return ((Comparable<E>)el1).compareTo(el2);
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
}
