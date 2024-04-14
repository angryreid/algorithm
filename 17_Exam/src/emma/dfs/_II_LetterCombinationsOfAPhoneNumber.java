package emma.dfs;

import java.util.ArrayList;
import java.util.List;

public class _II_LetterCombinationsOfAPhoneNumber {
    private final String[] lettersList = new String[] {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    }; // 2-9
    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        List<String> res = new ArrayList<>();
        char[] chars = digits.toCharArray();
        int len = chars.length;
        if (len == 0) return res;
        char[] string = new char[len];
        dfs(0, res, chars, string);
        return res;
    }

    private void dfs(int idx, List<String> res, char[] chars, char[] string) {
        if (idx == chars.length) {
            // add value;
            res.add(new String(string));
            return;
        }
        char[] letters = lettersList[chars[idx] - '2'].toCharArray();
        for (char ltr : letters) {
            string[idx] = ltr;
            dfs(idx + 1, res, chars, string);
        }
    }
}
