package emma.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _II_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, paths, candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> paths, int[] candidates, int target, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(paths));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int remain = target - candidates[i];
            if (remain < 0) continue;
            paths.add(candidates[i]);
            dfs(res, paths, candidates, remain, i);
            paths.removeLast();
        }
    }
}
