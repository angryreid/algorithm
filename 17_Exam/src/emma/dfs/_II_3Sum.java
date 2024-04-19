package emma.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _II_3Sum { // exceded time limit
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


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            // Skip the same numbers to avoid duplicate combinations
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // Skip the same numbers to avoid duplicate combinations
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
