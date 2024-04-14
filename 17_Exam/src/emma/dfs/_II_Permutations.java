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
        dfs(list, res, nums);
        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> res, int[] nums) {
        if (res.size() == nums.length) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int num : nums) {
            if (res.contains(num)) continue; // Skip the number if it's already in res
            res.add(num);
            dfs(list, res, nums);
            res.remove(res.size() - 1); // Remove the last added number
        }
    }
}