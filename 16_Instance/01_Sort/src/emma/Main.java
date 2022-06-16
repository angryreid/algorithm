package emma;

import emma.sort.*;
import emma.sort.cmp.*;
import emma.tool.Asserts;
import emma.tool.BinarySearch;
import emma.tool.Integers;
import emma.tool.Times;

import java.util.Arrays;

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

    public static void testBinarySearch() {
        int[] list = {1,2,3,4,5,6,7};
        Asserts.test(BinarySearch.indexOf(list, 4) == 3);
        Asserts.test(BinarySearch.indexOf(list, 1) == 0);
        Asserts.test(BinarySearch.indexOf(list, 7) == 6);
        Asserts.test(BinarySearch.indexOf(list, 2) == 1);
        Asserts.test(BinarySearch.indexOf(list, 43) == -1);

        Asserts.test(BinarySearch.search(list, 4) == 4);
        Asserts.test(BinarySearch.search(list, 1) == 1);
        Asserts.test(BinarySearch.search(list, 7) == 7);
        Asserts.test(BinarySearch.search(list, 2) == 2);
        Asserts.test(BinarySearch.search(list, 43) == 7);
    }

    public static void testThreadSort() {
        int[] list = {5,7,3,9,1};
        for (int i = 0; i < list.length; i++) {
//            new ThreadSort(list[i]).run();
            new ThreadSort(list[i]).start();
        }
    }

    public static void testSort(Integer[] list, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(list);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    public static void test() {
        Integer[] list = Integers.random(10000, 1, 10000);
        testSort(list,
                new BubbleSort(),
                new SelectionSort(),
                new HeapSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new ShellSort(),
                new CountingSort());
    }


    public static void main(String[] args) {
//        testBubble();
//        testSelection();
//        testHeapSort();
//        testBinarySearch();
//        testThreadSort();
        test();
    }
}
