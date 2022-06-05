package emma.sort;

import java.text.DecimalFormat;

public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {
    protected E[] list;
    private int cmpCount;
    private int swapCount;
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");
    public void sort(E[] list) {
        if (list == null || list.length < 2) return;
        this.list = list;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    @Override
    public int compareTo(Sort<E> o) {
        int res = (int)(time - o.time);
        if (res != 0) return res;
        res = cmpCount - o.cmpCount;
        if (res != 0) return res;
        return swapCount - o.swapCount;
    }

    protected abstract void sort();

    /**
     *
     * @param i1
     * @param i2
     * @return = 0 -> list[i1] == list[i2]
     * @return > 0 -> list[i1] > list[i2]
     * @return < 0 -> list[i1] < list[i2]
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        // empty handle ?
        return list[i1].compareTo(list[i2]);
    }

    protected int cmp(E v1, E v2) {
        cmpCount++;
        return v1.compareTo(v2);
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        E temp = list[i1];
        list[i1] = list[i2];
        list[i2] = temp;
    }

    @Override
    public String toString() {
        String timeStr = "Cost：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "Compared count：" + numberString(cmpCount);
        String swapCountStr = "Swap count：" + numberString(swapCount);
//        String stableStr = "稳定性：" + isStable();
        return "[" + getClass().getSimpleName() + "]\n"
//                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";

    }

    private String numberString(int number) {
        if (number < 1000) return "" + number;
        if (number < 1000000) return fmt.format(number / 1000.0) + "k";;
        if (number < 1000000000) return fmt.format(number / 1000000.0) + "m";
        return fmt.format(number / 1000000000.0) + "b";
    }
}
