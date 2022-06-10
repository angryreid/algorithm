package emma.sort;

public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] leftArray;
    @Override
    protected void sort() {
        leftArray = (E[]) new Object[list.length >> 1];
        sort(0, list.length);
    }

    /**
     * sort at [start, end)
     * @param start
     * @param end
     */
    private void sort(int start, int end) {
        if ((end - start) < 2) return; // only one element
        int mid = (start + end) >> 1;
        sort(start, mid);
        sort(mid, end);
        merge(start, mid, end);
    }

    /***
     * Merge [start, mid), [mid, end)
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int start, int mid, int end) {

    }
}
