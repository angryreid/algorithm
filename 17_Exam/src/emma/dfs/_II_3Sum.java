package emma.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _II_3Sum { // exceded time limit
    /**
     * @param nums: Give an array nums of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     *
     * Time complexity: O(n^3)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, path, nums, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int idx, int sum) {
        if (path.size() == 3) {
            if (sum == 0) res.add(new ArrayList<>(path));
            return;
        }

        int len = nums.length;
        for (int i = idx; i < len; i++) {
            // Skip the same numbers to avoid duplicate combinations
            if (i > idx && nums[i] == nums[i - 1]) continue;
            int value = nums[i] + sum;
            path.add(nums[i]);
            dfs(res, path, nums, i + 1, value);
            path.removeLast();
        }
    }


    /**
     * @param nums: Give an array nums of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     *
     * Time complexity: O(n^2)
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
