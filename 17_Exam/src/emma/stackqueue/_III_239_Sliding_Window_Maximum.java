package emma.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class _III_239_Sliding_Window_Maximum { // Define the class
    public int[] maxSlidingWindow(int[] nums, int k) { // Define a method to find the maximum value in each sliding window of size k
        if (k == 1) return nums; // If the window size is 1, return the original array
        int len = nums.length; // Get the length of the array
        int[] maxes = new int[len - k + 1]; // Initialize an array to store the maximum values
        Deque<Integer> deque = new LinkedList<>(); // Initialize a deque to store the indices of the elements in the window
        for (int i = 0; i < len; i++) { // Iterate over the array
            int v = nums[i]; // Get the current element
            while (!deque.isEmpty() && v >= nums[deque.peekLast()]) { // While the deque is not empty and the current element is greater than or equal to the last element in the deque
                deque.pollLast(); // Remove the last element from the deque
            }

            deque.offerLast(i); // Add the index of the current element to the deque

            int w = i - k + 1; // Calculate the index of the first element in the window
            if (w < 0) continue; // If the window has not yet reached its full size, continue to the next iteration
            if (deque.peekFirst() < w) { // If the first element in the deque is outside the window
                deque.pollFirst(); // Remove the first element from the deque
            }
            maxes[w] = nums[deque.peekFirst()]; // Set the maximum value in the window to be the first element in the deque
        }
        return maxes; // Return the array of maximum values
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 1) return nums;
        int len = nums.length;
        int[] maxes = new int[len - k + 1];
        int maxIdx = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        maxes[0] = nums[maxIdx];
        for (int li = 1; li < maxes.length; li++) {
            int ri = li + k - 1;
            if (maxIdx < li) {
                maxIdx = li;
                for (int i = li + 1; i <= ri; i++) {
                    if (nums[i] > nums[maxIdx]) maxIdx = i;
                }
            } else if (nums[ri] >= nums[maxIdx]) {
                maxIdx = ri;
            }
            maxes[li] = nums[maxIdx];
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
