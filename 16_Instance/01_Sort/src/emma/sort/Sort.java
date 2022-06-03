package emma.sort;

public abstract class Sort {
    protected Integer[] list;
    private int cmpCount;
    private int swapCount;
    public void sort(Integer[] list) {
        if (list == null || list.length < 2) return;
        this.list = list;
        sort();
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
        return list[i1] - list[i2];
    }

    protected int cmpEl(Integer v1, Integer v2) {
        cmpCount++;
        return v1 - v2;
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        int temp = list[i1];
        list[i1] = list[i2];
        list[i2] = temp;
    }
}
