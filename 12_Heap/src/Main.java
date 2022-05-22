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

    public static void main(String[] args) {
        testAdd();//
    }
}
