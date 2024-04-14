package emma.dfs;

import java.util.ArrayList;
import java.util.List;

public class _II_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if (len == 0) return list;
        List<Integer> res = new ArrayList<>();
        boolean[] used = new boolean[len]; // Boolean array to keep track of used numbers
        dfs(list, res, nums, used);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> res, int[] nums, boolean[] used) {
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip the number if it's already in res
            res.add(nums[i]);
            used[i] = true; // Mark the number as used
            dfs(list, res, nums, used);
            used[i] = false; // Unmark the number after the recursive call
            res.remove(res.size() - 1); // Remove the last added number
        }
    }
}