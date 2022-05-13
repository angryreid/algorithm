package emma.tree;

import java.util.Comparator;

public class BST<E> extends BinaryTree<E> {
  private Comparator<E> comparator;

  public BST(Comparator<E> comparator) {
    this.comparator = comparator;
  }

  public BST() {
    this(null);
  }

  /**
   * To AVL tree balance
   * @param node new add node
   */
  protected void afterAdd(Node<E> node) {}

  public void add(E element) {
    checkElementNull(element);

    if (root == null) { // first node
      root = createNode(element, null);
      size++;
      afterAdd(root);
      return;
    }

    // Add other node
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
    Node<E> newNode = createNode(element, parent);
    if (compareRes > 0) {
      parent.right = newNode;
    } else {
      parent.left = newNode;
    }
    size++;
    afterAdd(newNode);
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

  /**
   * interface function to call after removed node.
   * Offer to instance use
   * @param node deleted node or replacement node.
   */
  protected void afterRemove(Node<E> node) {}

  private void remove(Node<E> node) {
    if (node == null) return;
    size--;
    if (node.fullLeaf()) { // Handing this case specially.
      Node<E> pre = predecessor(node);
      node.element = pre.element;
      node = pre;// Binding the value to delete later.
    }

    // remove node.
    if (node.isLeaf()) {
      if (node.parent == null) node = null;
      if (node == node.parent.left) {
        node.parent.left = null;
      } else {
        node.parent.right = null;
      }
      afterRemove(node);
    } else {
      Node<E> replaceNode = node.left != null ? node.left : node.right;
      replaceNode.parent = node.parent;
      if (node.parent == null) { // node is root and has only one child
        root = replaceNode;
      }else if (node == node.parent.left) {
        node.parent.left = replaceNode;
      } else {
        node.parent.right = replaceNode;
      }
      afterRemove(replaceNode);
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

  public E getPredesessor(E element) {
    Node<E> p = predecessor(findNode(element));
    if (p != null) {
      return p.element;
    } else {
      return null;
    }
  }

  public E getSubdesessor(E element) {
    Node<E> s = subdecessor(findNode(element));
    if (s != null) {
      return s.element;
    } else {
      return null;
    }
  }

  private void checkElementNull(E element) {
    if (element == null) {
      throw new IllegalArgumentException("element must not be null");
    }
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

  public boolean contains(E element) {
    return findNode(element) != null;
  }
}
