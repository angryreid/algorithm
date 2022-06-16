package emma.sort.cmp;

import emma.sort.Sort;

public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, list.length);
    }

    /**
     * [start, end)
     * @param start
     * @param end
     */
    private void sort(int start, int end) {
        if (end - start < 2) return;// At lest 2 elements required.
        // 1. Find the pivot
        int pivot = pivotIndex(start, end);
        // 2. Sort sub list
        sort(start, pivot);
        sort(pivot + 1, end);
    }

    /**
     * Find the pivot from [start, end)
     * @param start
     * @param end
     * @return Index of pivot
     */
    private int pivotIndex(int start, int end) {
        // Select pivot with random
        swap(start, start + (int)(Math.random() * (end - start)));
        E pivotValue = list[start];
        end--;// Point at the last element position
        while (start < end) {
            while (start < end) {
                if (cmp(pivotValue, list[end]) < 0) { // Think if using <= at here, what will happen ?
                    end--;
                } else {
                    list[start++] = list[end];
                    break;
                }
            }
            while (start < end) {
                if (cmp(pivotValue, list[start]) > 0) { // Think if using >= at here, what will happen ?
                    start++;
                } else {
                    list[end--] = list[start];
                    break;
                }
            }
        }
        list[end] = pivotValue;
        return end;
    }
}
