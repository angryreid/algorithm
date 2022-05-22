package emma.heap;

import emma.printer.BinaryTreeInfo;
import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E elements[];

    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap(Comparator<E> comparator) {
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null);
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    @Override
    public void add(E element) {
        if (element == null) return;
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    @Override
    public E get() {
        if (size == 0) return null;
        return elements[0];
    }

    @Override
    public E remove() {
        if (size == 0) return null;
        E head = elements[0];
        int tailIndex = --size;
        elements[0] = elements[tailIndex];
        elements[tailIndex] = null;
        siftDown(0);
        return head;
    }

    @Override
    public E replace(E element) {
        if (size == 0) return null;
        E head = elements[0];
        int tailIndex = --size;
        elements[0] = elements[tailIndex];
        elements[tailIndex] = null;
        siftDown(0);
        return head;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("->" + elements[i]);
        }
        System.out.println();
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * O(logn)
     * @param index
     */
    private void siftUp(int index) {
        E element = elements[index];
        while (index > 0) {
            int fatherIndex = (index - 1) >> 1;
            E father = elements[fatherIndex];
            if (compare(father, element) >= 0) break;
            elements[index] = father;
            index = fatherIndex;
        }
        elements[index] = element;
    }

    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        while (index < half) { // index is not leaf node which equals the number of parent nodes.
            // one child.
            // two child
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            int rightIndex = childIndex + 1;
            E rightChild = elements[rightIndex];
            if (rightIndex < size && compare(rightChild, child) > 0) {
                childIndex = rightIndex;
                child = rightChild;
            }
            if (compare(element, child) >= 0) break;
            elements[index] = child;
            index = childIndex;
        }
        elements[index] = element;
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int leftIndex = ((int) node << 1) + 1;
        return leftIndex > size - 1 ? null : leftIndex;
    }

    @Override
    public Object right(Object node) {
        int rightIndex = ((int) node << 1) + 2;
        return rightIndex > size - 1 ? null : rightIndex;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }
}
