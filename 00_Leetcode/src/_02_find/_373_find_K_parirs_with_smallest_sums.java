package _02_find;

import java.lang.reflect.Array;
import java.util.*;

public class _373_find_K_parirs_with_smallest_sums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[] {i, 0});
        }
        List<List<Integer>> list = new ArrayList<>();
        while (k-- > 0 && !heap.isEmpty()) {
            int[] pos = heap.poll();
            list.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
            if (++pos[1] < nums2.length) {
                heap.offer(pos);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}
