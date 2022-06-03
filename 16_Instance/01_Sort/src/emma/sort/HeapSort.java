package emma.sort;

public class HeapSort extends Sort {
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
        Integer element = list[index];
        int half = size >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            Integer child = list[childIndex];
            int rightIndex = childIndex + 1;
//            Integer rightChild = list[rightIndex]; // Not working ??? Fix: The right size maybe out of bound
//            if (rightIndex < size && cmpEl(rightChild, child) > 0) {
//                child = list[childIndex = rightIndex];
//            }
            if (rightIndex < size && cmpEl(list[rightIndex], child) > 0) {
                child = list[childIndex = rightIndex];
            }
            if (cmpEl(element, child) >= 0) break;
            list[index] = child;
            index = childIndex;
        }
        list[index] = element;
    }
}
