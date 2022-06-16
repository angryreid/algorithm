package emma.sort;

public class CountingSort extends Sort<Integer>{
    @Override
    protected void sort() {
        // Find the biggest integer.
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        // Create a new Array with the biggest size.
        int[] counts = new int[max + 1];
        for (int i = 0; i < list.length; i++) {
            counts[list[i]]++;
        }
        // Sort origin list with counts.
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int cnt = counts[i];
            while ((cnt--) > 0) {
                list[index++] = i;
            }
        }
    }
}
