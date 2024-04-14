package emma.dfs;

import java.util.ArrayList;
import java.util.List;

public class _II_LetterCombinationsOfAPhoneNumber {

    private List<String> res;
    private char[] chars;
    private final String[] lettersList = new String[] {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    }; // 2-9

    private char[] string;
    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        res = new ArrayList<>();
        chars = digits.toCharArray();
        int len = chars.length;
        if (len == 0) return res;
        string = new char[len];
        dfs(0);
        return res;
    }

    private void dfs(int idx) {
        if (idx == chars.length) {
            // add value;
            res.add(new String(string));
            return;
        }
        char[] letters = lettersList[chars[idx] - '2'].toCharArray();
        for (char ltr : letters) {
            string[idx] = ltr;
            dfs(idx + 1);
        }
    }
}
