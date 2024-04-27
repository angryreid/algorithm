package _06_math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _II_MeetingRoomsII {
    // Method to find the minimum number of meeting rooms needed
    /**
     * Time complexity: O(nlogn) for sorting the intervals array
     */
    public int minMeetingRooms(int[][] intervals) {
        // If the intervals array is null or empty, return 0
        if (intervals == null || intervals.length == 0) return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));

        // Create a min heap to track the end time of the meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // default is min Heap

        // Add the end time of the first meeting to the min heap
        minHeap.add(intervals[0][1]);

        // Iterate over the rest of the meetings
        for (int i = 1; i < intervals.length; i++) {
            // If the start time of the current meeting is not earlier than the end time of the earliest ending meeting
            if (intervals[i][0] >= minHeap.peek()) {
                // Remove the earliest ending meeting from the min heap
                minHeap.poll();
            }
            // Add the end time of the current meeting to the min heap
            minHeap.add(intervals[i][1]);
        }
        // The size of the min heap is the minimum number of meeting rooms needed
        return minHeap.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
        // If the intervals array is null or empty, return 0
        if (intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;;
        int[] startTimes = new int[len];
        int[] endTimes = new int[len];
        for (int i = 0; i < len; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int room = 0, endIdx = 0;
        for (int start : startTimes) {
            if (start < endTimes[endIdx]) {
                room++;
            } else {
                endIdx++;
            }
        }
        return room;
    }
}