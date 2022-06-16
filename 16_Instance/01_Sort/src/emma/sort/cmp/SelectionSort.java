package emma.sort.cmp;

import emma.sort.Sort;

public class SelectionSort<E extends Comparable<E>> extends Sort<E> {
    public void sort() {
        for (int tail = list.length - 1; tail > 0; tail--) {
            int maxIndex = 0;
            for (int head = 1; head <= tail; head++) {
                if (cmp(maxIndex, head) <= 0) {
                    maxIndex = head;
                }
            }
            swap(maxIndex, tail);
        }
    }
}
