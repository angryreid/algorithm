package emma.sort.cmp;

import emma.sort.Sort;

public class BubbleSort<E extends Comparable<E>> extends Sort<E> {

    public void sort() {
        for (int i = list.length - 1; i > 0; i--) {
            boolean sort = true;
            for (int j = 1; j <= i; j++) {
                if (cmp(j, j - 1) < 0) {
                   swap(j, j - 1);
                    sort = false;
                }
            }
            if (sort) break;
        }
    }

    public static void bubbleSortedIndex(Integer[] list) { // Applying for sorted number at the tail.
        for (int i = list.length - 1; i > 0; i--) {
            int sortedIndex = 1; // Sorted Array will use it.
            for (int j = 1; j <= i; j++) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    sortedIndex = j;
                }
            }
            i = sortedIndex;
        }
    }

    public static void bubbleAsc(Integer[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
