package emma.queue;

import emma.heap.BinaryHeap;
import emma.heap.Heap;

public class PriorityQueue<E> implements Queue<E> {
    private Heap<E> heap = new BinaryHeap<>();
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void enQueue(E element) {

    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public E front() {
        return null;
    }
}
