package emma.heap;


import java.util.Collection;
import java.util.Comparator;

public class MinHeap<E> {
    private E elements[];

    private int size;
    private Comparator<E> comparator;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int compare(E e1, E e2) {
        if (comparator == null) {
            return ((Comparable<E>)e1).compareTo(e2);
        } else {
            return comparator.compare(e1, e2);
        }
    }

    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap(Collection<E> elements, Comparator<E> comparator) {
        this.comparator = comparator;

        size = elements == null ? 0 : elements.size();
        if (size == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            int capacity = Math.max(size, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            int i = 0;
            for (E element : elements) {
                this.elements[i++] = element;
            }
            heapify();
        }
    }

    public MinHeap(E[] elements, Comparator<E> comparator)  {
        this.comparator = comparator;

        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public MinHeap(Collection<E> elements)  {
        this(elements, null);
    }

    public MinHeap(E[] elements)  {
        this(elements, null);
    }

    public MinHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MinHeap() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }


    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    public void add(E element) {
        if (element == null) return;
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    public void addAll(Collection<E> elements) {
        if (elements == null) return;
        for (E element : elements) {
            add(element);
        }
    }

    public void addAll(E[] elements) {
        if (elements == null) return;
        for (E element : elements) {
            add(element);
        }
    }

    public E get() {
        emptyCheck();
        return elements[0];
    }

    public E remove() {
        emptyCheck();
        E head = elements[0];
        int tailIndex = --size;
        elements[0] = elements[tailIndex];
        elements[tailIndex] = null;
        siftDown(0);
        return head;
    }

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
            if (compare(father, element) < 0) break;
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
            if (rightIndex < size && compare(elements[rightIndex], child) < 0) {
                child = elements[childIndex = rightIndex];
            }
            if (compare(element, child) <= 0) break;
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

    public Object root() {
        return 0;
    }

    public Object left(Object node) {
        int leftIndex = ((int) node << 1) + 1;
        return leftIndex > size - 1 ? null : leftIndex;
    }

    public Object right(Object node) {
        int rightIndex = ((int) node << 1) + 2;
        return rightIndex > size - 1 ? null : rightIndex;
    }

    public Object string(Object node) {
        return elements[(int) node];
    }
}
