package emma.sort;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int head = 1; head < list.length; head++) {
            int tail = head;
            E copyHead = list[tail];
            while (tail > 0 && cmp(copyHead, list[tail - 1]) < 0) {
                list[tail] = list[tail - 1];
                tail--;
            }
            list[tail] = copyHead;
        }
    }
}
