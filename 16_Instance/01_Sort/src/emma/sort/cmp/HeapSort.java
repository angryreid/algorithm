package emma.sort.cmp;

import emma.sort.Sort;

public class HeapSort<E extends Comparable<E>> extends Sort<E> {
    private int size;

    public void sort() {
        size = list.length;
        // In-place creating HEAP via siftDown
        for (int i = ((size >> 1) - 1); i >= 0; i--) {
            siftDown(i);
        }

        while (size > 1) {
            // Heap excludes the max number by reduce the size
            swap(0, --size);
            // One time siftDown will move the max number to the top
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        E element = list[index];
        int half = size >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            E child = list[childIndex];
            int rightIndex = childIndex + 1;
            if (rightIndex < size && cmp(list[rightIndex], child) > 0) {
                child = list[childIndex = rightIndex];
            }
            if (cmp(element, child) >= 0) break;
            list[index] = child;
            index = childIndex;
        }
        list[index] = element;
    }
}
