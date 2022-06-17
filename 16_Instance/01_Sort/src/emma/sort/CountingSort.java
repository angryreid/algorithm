package emma.sort;

public class CountingSort extends Sort<Integer>{
    @Override
    protected void sort() {
        // Find the max, min integer.
        int max = list[0];
        int min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
            if (list[i] < min) {
                min = list[i];
            }
        }
        // Create a new Array.
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < list.length; i++) {
            counts[list[i] - min]++;
        }
        // Accumulation counts
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // Sort from tail to head to make sure the stability

        int[] sortedList = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            sortedList[--counts[list[i] - min]] = list[i];
        }

        for (int i = 0; i < sortedList.length; i++) {
            list[i] = sortedList[i];
        }
    }
}
