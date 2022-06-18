package emma.sort;

public class RadixSort extends Sort<Integer>{
    @Override
    protected void sort() {
        // Find the max, min integer.
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }

        for (int divider = 1; divider <= max; divider *= 10) {
            countingSort(divider);
        }
    }

    protected void countingSort(int divider) {

        // Create a new Array.
        int[] counts = new int[10];
        for (int i = 0; i < list.length; i++) {
            // Save radix counting
            counts[list[i] / divider % 10]++;
        }
        // Accumulation counts
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // Sort from tail to head to make sure the stability

        int[] sortedList = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            // Place the actual element.
            sortedList[--counts[list[i] / divider % 10]] = list[i];
        }

        for (int i = 0; i < sortedList.length; i++) {
            list[i] = sortedList[i];
        }
    }
}
