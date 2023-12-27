package emma.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class _III_239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int len = nums.length;
        int[] maxes = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int v = nums[i];
            while (!deque.isEmpty() && v >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            int w = i - k + 1;
            if (w < 0) continue;
            if (deque.peekFirst() < w) {
                deque.pollFirst();
            }
            maxes[w] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}


// package emma.stackqueue;

// import java.util.Deque;
// import java.util.LinkedList;

// public class _III_239_Sliding_Window_Maximum {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (k == 1) return nums;
//         int len = nums.length;
//         int[] maxes = new int[len - k + 1];
//         Deque<Integer> deque = new LinkedList<>();
//         for (int i = 0; i < len; i++) {
//             int v = nums[i];
//             while (!deque.isEmpty() && v >= nums[deque.peekLast()]) {
//                 deque.pollLast();
//             }

//             deque.offerLast(i); // Store the index, not the value

//             int w = i - k + 1;
//             if (w < 0) continue;
//             if (deque.peekFirst() < w) {
//                 deque.pollFirst();
//             }
//             maxes[w] = nums[deque.peekFirst()]; // Corrected line
//         }
//         return maxes;
//     }
// }
