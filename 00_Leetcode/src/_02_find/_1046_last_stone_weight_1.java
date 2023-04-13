package _02_find;

import java.util.PriorityQueue;
import java.util.Queue;

public class _1046_last_stone_weight_1 {

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if (first > second) {
                queue.offer(first - second);
            }
        }
        return queue.size() > 0 ? queue.poll() : 0;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
