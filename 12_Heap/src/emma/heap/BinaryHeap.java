package emma.heap;

import emma.printer.BinaryTreeInfo;
import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E elements[];

    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if(elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            int capacity = Math.max(DEFAULT_CAPACITY, elements.length);
            size = elements.length;
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(E[] elements) {
       this(elements, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
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
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        E head = elements[0];
        int tailIndex = --size;
        elements[0] = elements[tailIndex];
        elements[tailIndex] = null;
        siftDown(0);
        return head;
    }

    @Override
    public E replace(E element) {
        if (element == null) return null;
        E head = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            head = elements[0];
            elements[0] = element;
            siftDown(0);
        }
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

    private void heapify() {
        // 1. Sift up from the top
//        for (int i = 1; i < size; i++) {
//            siftUp(i);
//        }
        // 2. Sift down from the parent node.
        for (int i = ((size >> 1) - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new OutOfMemoryError("Heap is empty");
        }
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
