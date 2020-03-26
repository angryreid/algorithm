package list;

import java.lang.reflect.Field;
import java.security.acl.LastOwnerException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class LinkedList<E> extends AbstractList<E> {
  private Node<E> first;
  private Node<E> last;

  private class Node<E> {
    E element;
    Node<E> prev;
    Node<E> next;

    public Node(Node<E> prev, E element, Node<E> next) {
      this.prev = prev;
      this.element = element;
      this.next = next;
    }

    @Override
    public String toString() {
      StringBuilder sBuilder = new StringBuilder();
      if (prev != null) {
        sBuilder.append(prev.element);
      } else {
        sBuilder.append("null");
      }
      sBuilder.append("_").append(element).append("_");
      if (next != null) {
        sBuilder.append(next.element);
      } else {
        sBuilder.append("null");
      }
      return sBuilder.toString();

    }
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    size = 0;
    first = null;
    last = null;
  }

  @Override
  public E get(int index) {
    // TODO Auto-generated method stub
    return node(index).element;
  }

  @Override
  public E set(int index, E element) {
    // TODO Auto-generated method stub
    Node<E> node = node(index);
    E oldE = node.element;
    node.element = element;
    return oldE;
  }

  @Override
  public void add(int index, E element) {
    // TODO Auto-generated method stub
    rangeCheckForAdd(index);
    if (index == size) {// add tail
      Node<E> oldLastNode = last;
      last = new Node<>(oldLastNode, element, null);
      if (oldLastNode == null) { // add first node
        first = last;
      } else { // normal add operation
        oldLastNode.next = last;
      }
    } else {
      Node<E> nextNode = node(index);
      Node<E> prevNode = nextNode.prev;
      Node<E> node = new Node<>(prevNode, element, nextNode);
      nextNode.prev = node;
      if (prevNode == null) { // index == 0
        first = node;
      } else {
        prevNode.next = node;
      }
    }
    size++;
  }

  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    rangeCheck(index);
    Node<E> node = node(index);
    Node<E> prevNode = node.prev;
    Node<E> nexNode = node.next;
    if (prevNode == null) {// index == 0
      first = nexNode;
    } else {
      prevNode.next = nexNode;
    }
    if (nexNode == null) { // index == size
      last = prevNode;
    } else {
      nexNode.prev = prevNode;
    }
    size--;
    return node.element;
  }

  @Override
  public int indexOf(E element) {
    // TODO Auto-generated method stub
    if (element == null) {
      Node<E> node = first;
      for (int i = 0; i < size; i++) {
        if (node.element == null) {
          return i;
        }
        node = node.next;
      }
    } else {
      Node<E> node = first;
      for (int i = 0; i < size; i++) {
        if (element.equals(node.element)) {
          return i;
        }
        node = node.next;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  private Node<E> node(int index) {
    rangeCheck(index);
    if (index < (size >> 1)) {
      Node<E> node = first;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      return node;
    } else {
      Node<E> node = last;
      for (int i = size - 1; i > index; i--) {
        node = node.prev;
      }
      return node;
    }
  }

  public String tosString() {
    StringBuilder string = new StringBuilder();
    string.append("size=").append(size).append(", [");
    Node<E> node = first;
    for (int i = 0; i < size; i++) {
      if (i != 0) {
        string.append(", ");
      }

      string.append(node);

      node = node.next;
    }
    string.append("]");
    return string.toString();
  }

}
