package emma;

import emma.bubble.Bubble;
import emma.selection.Selection;
import emma.tool.Integers;
import emma.tool.Times;

public class Main {
    public static void testBubble() {
//        Integer[] list = Integers.random(10000, 1, 12000);
        Integer[] list = Integers.tailAscOrder(1, 10000, 2000);
        Integer[] list2 = Integers.copy(list);
        Integer[] list3 = Integers.copy(list);
        Times.test("Bubble Sort Swap", () -> {
            Bubble.bubbleSwap(list);
        });

        Times.test("Bubble Sort Asc", () -> {
            Bubble.bubbleAsc(list2);
        });

        Times.test("Bubble Sort Sorted Index", () -> {
            Bubble.bubbleSortedIndex(list3);
        });
    }

    public static void testSelection() {
        Integer[] list = Integers.random(100, 1, 200);
        Times.test("Selection test", () -> {
            Selection.selectAsc(list);
        });
        Integers.println(list);
    }


    public static void main(String[] args) {
//        testBubble();
        testSelection();
    }
}
