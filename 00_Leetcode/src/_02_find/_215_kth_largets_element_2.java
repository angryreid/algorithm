package _02_find;

import java.util.PriorityQueue;
import java.util.Queue;

public class _215_kth_largets_element_2 {

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b -a);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        while (--k > 0) {
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }
}
