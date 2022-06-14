package emma.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence();
        for (Integer step :
                stepSequence) {
            sort(step);
        }
    }

    /**
     * Split into steps column, Then sorting the element of each row.
     * @param step
     */
    private void sort(int step) {

        for (int col = 0; col < step; col++) {
            for (int start = 0; start < list.length; start++) {
                int cur = start;
                while (cur > 0 && cmp(cur, cur - 1) < 0) {
                    swap(cur, cur - 1);
                    cur--;
                }
            }
        }
    }

    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = list.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }

}
