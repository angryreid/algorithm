package emma.sort;

public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, list.length);
    }

    /**
     * sort at [start, end)
     * @param start
     * @param end
     */
    private void sort(int start, int end) {
        if ((end - start) < 2) return;
        
    }
}
