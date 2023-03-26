package _02_find;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2395_1 {
    // https://leetcode.cn/problems/find-subarrays-with-equal-sum/
    public static void main(String[] args) {
//        int[] nums = {4, 2, 4};
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {0, 0, 0};

        System.out.println(findSubarrays2(nums));
    }
    static boolean findSubarrays(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            if (map.containsKey(sum)) return true;
            map.put(sum, false);
        }
        return false;
    }

    static boolean findSubarrays2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            if (!set.add(sum)) return true;
        }
        return false;
    }
}
