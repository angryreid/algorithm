package emma;

import emma.sort.BubbleSort;
import emma.sort.HeapSort;
import emma.sort.SelectionSort;
import emma.sort.Sort;
import emma.tool.Asserts;
import emma.tool.Integers;
import emma.tool.Times;

public class Main {
    public static void testBubble() {
//        Integer[] list = Integers.random(10000, 1, 12000);
        Integer[] list = Integers.tailAscOrder(1, 10000, 2000);
        Integer[] list2 = Integers.copy(list);
        Integer[] list3 = Integers.copy(list);
        Times.test("Bubble Sort Swap", () -> {
            new BubbleSort().sort(list);
        });
    }

    public static void testSelection() {
        Integer[] list = Integers.random(100, 1, 200);
        Times.test("Selection test", () -> {
            new SelectionSort().sort(list);
        });
        Asserts.test(Integers.isAscOrder(list));
    }

    public static void testHeapSort() {
        Integer[] list = Integers.random(100, 1, 200);
//        Integer[] list = {2,3,1,4,5};
        Times.test("Selection test", () -> {
            new HeapSort().sort(list);
        });
        Asserts.test(Integers.isAscOrder(list));
    }

    public static void testSort(Integer[] list, Sort... sorts) {
        for (Sort sort : sorts) {
            sort.sort(Integers.copy(list));
            System.out.println(sort);
        }
    }

    public static void test() {
        Integer[] list = Integers.random(10000, 1, 20000);
        testSort(list, new BubbleSort(), new SelectionSort(), new HeapSort());
    }


    public static void main(String[] args) {
//        testBubble();
//        testSelection();
//        testHeapSort();
        test();
    }
}
