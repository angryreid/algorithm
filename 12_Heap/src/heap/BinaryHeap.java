package heap;

import java.util.Comparator;

public class BinaryHeap<E> implements Heap<E> {
    private E elements[];
    private int size;
    private Comparator<E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    private int compare(E e1, E e2) {
        if (comparator == null) {
            return ((Comparable<E>)e1).compareTo(e2);
        } else {
            return comparator.compare(e1, e2);
        }
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
     * @param i
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
//        if (i == 0) return;
//        int fatherIndex = (int)Math.floor((i-1)/2);
//        while (fatherIndex > 0 && compare(elements[fatherIndex], elements[i]) > 0) {
//            E temp = elements[fatherIndex];
//            elements[fatherIndex] = elements[i];
//            elements[i] = temp;
//            i = fatherIndex;
//            fatherIndex = (int)Math.floor((i-1)/2);
//        }
    }
}
