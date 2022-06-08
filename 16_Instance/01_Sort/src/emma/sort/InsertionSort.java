package emma.sort;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int head = 1; head < list.length; head++) {
            insert(head, search(head));
        }
    }

    private void insert(int source, int dest) {
        E v = list[source];
        for (int i = source; i > dest ; i--) {
            list[i] = list[i - 1];
        }
        list[dest] = v;
    }


    /**
     * The cur position of sorting list
     * @param index
     * @return
     */
    private int search(int index) {
        E v = list[index];
        int start = 0,end = index;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (cmp(v, list[mid]) < 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
