import emma.heap.BinaryHeap;
import emma.printer.BinaryTreeInfo;
import emma.printer.BinaryTrees;

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

    public static void main(String[] args) {
//        testAdd();//
//        testRemove();
        testReplace();
    }
}
