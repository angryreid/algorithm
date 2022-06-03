package emma.selection;

public class Selection {
    public static void selectAsc(Integer[] list) {
        for (int tail = list.length - 1; tail > 0; tail--) {
            int maxIndex = 0;
            for (int head = 1; head <= tail; head++) {
                if (list[maxIndex] < list[head]) {
                    maxIndex = head;
                }
            }
            int temp = list[maxIndex];
            list[maxIndex] = list[tail];
            list[tail] = temp;
        }
    }
}
