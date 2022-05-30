package emma;

import emma.tool.Integers;
import emma.tool.Times;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        Integer[] list = Integers.random(20000, 1, 100000);
        Integer[] list2 = Integers.copy(list);
        Times.test("Bubble Sort 1", () -> {
            for (int i = list.length - 1; i > 0; i--) {
                boolean sort = true;
                for (int j = 1; j <= i; j++) {
                    if (list[j] < list[j - 1]) {
                        int temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                        sort = false;
                    }
                }
                if (sort) break;
            }
        });

        Times.test("Bubble sort 2", () -> {
            for (int i = 0; i < list2.length - 1; i++) {
                for (int j = i + 1; j < list2.length; j++) {
                    if (list2[i] > list2[j]) {
                        int temp = list2[i];
                        list2[i] = list2[j];
                        list2[j] = temp;
                    }
                }
            }
        });

//        [Bubble Sort 1]
//        Start time: 22:54:06.692
//        End time: 22:54:08.753
//        Cost: 2.061s
//        -------------------------------------
//        [Bubble sort 2]
//        Start time: 22:54:08.755
//        End time: 22:54:09.827
//        Cost: 1.072s
//        -------------------------------------
    }
}
