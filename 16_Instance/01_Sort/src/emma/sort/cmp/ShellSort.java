package emma.sort.cmp;

import emma.sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
//        List<Integer> stepSequence = shellStepSequence();
        List<Integer> stepSequence = sedgewickSequence();
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
            for (int start = col + step; start < list.length; start += step) {
                // index = col + row * step
                int cur = start;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
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

    private List<Integer> sedgewickSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int k = 0, step = 0, count = list.length;
        while(true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= count) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }

}
