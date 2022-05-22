import emma.heap.BinaryHeap;
import emma.printer.BinaryTreeInfo;
import emma.printer.BinaryTrees;

import java.util.Comparator;

public class Main {

    public static void testAdd() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        int[] list = {22,33,44,11,66,77,88,555};
        for (int num :
                list) {
            heap.add(num);
        }
        heap.print(); // ->555->88->77->44->22->33->66->11
        BinaryTrees.println(heap);
    }

    public static void testRemove() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        int[] list = {22,33,44,11,66,77,88,555};
        for (int num :
                list) {
            heap.add(num);
        }
        heap.print(); // ->555->88->77->44->22->33->66->11
        int head = heap.remove();
        System.out.println("Removed head: " + head);
        BinaryTrees.println(heap);
    }

    public static void testReplace() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        int[] list = {22,33,44,11,66,77,88,555};
        for (int num :
                list) {
            heap.add(num);
        }
        heap.print(); // ->555->88->77->44->22->33->66->11
        int head = heap.replace(6);
        System.out.println("Replace head of heap: " + head);
        BinaryTrees.println(heap);
    }

    public static void testHeapify() {
        Integer[] list = {22,33,44,11,66,77,88,555};
        BinaryHeap<Integer> heap = new BinaryHeap<>(list);
        BinaryTrees.println(heap);
    }

    public static void testMinBinaryHeap() {
        Integer[] list = {22,33,44,11,66,77,88,555};
        BinaryHeap<Integer> heap = new BinaryHeap<>(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BinaryTrees.println(heap);
    }

    public static void testTopK() {
        Integer[] list = {98, 65, 46, 69, 67, 92, 55, 57,
                10, 74, 79, 50, 2, 32, 33, 87, 40, 11,
                82, 16, 25, 96, 94, 47, 23, 68, 42};
        int topK = 5;
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < list.length; i++) {
            if (i < topK) {
                heap.add(list[i]);
            } else if (list[i] > heap.get()) {
                heap.replace(list[i]);
            }
        }
        BinaryTrees.println(heap);
    }

    public static void main(String[] args) {
//        testAdd();//
//        testRemove();
//        testReplace();
//        testHeapify();
//        testMinBinaryHeap();
        testTopK();
    }
}
