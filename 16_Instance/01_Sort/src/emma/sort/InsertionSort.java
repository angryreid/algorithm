package emma.sort;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int head = 1; head < list.length; head++) {
            int tail = head;
            while (tail > 0 && cmp(tail, tail - 1) < 0) {
                swap(tail, tail - 1);
                tail--;
            }
        }
    }
}
