package emma.dfs;

import java.util.ArrayList;
import java.util.List;

public class _II_GenerateParentheses {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, n, "");
        return res;
    }

    private void dfs(int l, int r, String s) {
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        if (l > 0) {
            dfs(l - 1, r, s + "(");
        }
        if (l < r) {
            dfs(l, r - 1, s + ")");
        }
    }
}

/**
 *
 * Solution 1
 *
 * List<String> res;
 *     public List<String> generateParenthesis(int n) {
 *         res = new ArrayList<>();
 *         dfs(n, n, "");
 *         return res;
 *     }
 *
 *     private void dfs(int l, int r, String s) {
 *         if (l == 0 && r == 0) {
 *             res.add(s);
 *             return;
 *         }
 *         if (l > 0) {
 *             dfs(l - 1, r, s + "(");
 *         }
 *         if (l < r) {
 *             dfs(l, r - 1, s + ")");
 *         }
 *     }
 */