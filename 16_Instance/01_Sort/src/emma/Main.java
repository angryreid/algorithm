package emma;

import emma.bubble.Bubble;
import emma.tool.Integers;
import emma.tool.Times;

public class Main {
    public static void testBubble() {
        Integer[] list = Integers.random(1000, 1, 100000);
        Integer[] list2 = Integers.copy(list);
        Times.test("Bubble Sort 1", () -> {
            Bubble.bubbleSwap(list);
        });

        Times.test("Bubble sort 2", () -> {
            Bubble.bubbleAsc(list2);
        });
    }


    public static void main(String[] args) {
        testBubble();
    }
}
