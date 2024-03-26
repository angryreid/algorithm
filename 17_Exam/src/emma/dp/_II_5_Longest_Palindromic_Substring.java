package emma.dp;

public class _II_5_Longest_Palindromic_Substring {
    /**
     * Nick's solution
     * @param s input string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null) return null;
        String res = "";
        char[] stringList = s.toCharArray();
        // dp[i][j] -> s[i, j];
        // j - i + 1 <= 2
        // Yes -> dp[i][j] = s[i] == s[j]
        // No  -> dp[i][j] = s[i + 1][j - 1] && s[i] == s[j];
        int len = stringList.length, max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = i; j < len; j++) {
                int subLen = j - i;
                boolean headIsTail = stringList[i] == stringList[j];
//                if (subLen <= 2) {
//                    dp[i][j] = headIsTail;
//                } else {
//                    dp[i][j] = dp[i + 1][j - 1] && headIsTail;
//                }
                dp[i][j] = headIsTail && (subLen <= 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && subLen > max) {
                    max = subLen;
                    res = s.substring(i, j + 1); // end index in substring is exclusive
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        if (s == null) return null;
        String res = "";
        char[] stringList = s.toCharArray();
        int len = stringList.length, left = 0, maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = i; j < len; j++) {
                int subLen = j - i + 1;
                boolean headIsTail = stringList[i] == stringList[j];
                dp[i][j] = headIsTail && (subLen <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && subLen > maxLen) {
                    maxLen = subLen;
                    left = i;
                }
            }
        }
        return new String(stringList, left, maxLen);
    }

    // 1d array
    public String longestPalindrome3(String s) {
        if (s == null) return null;
        String res = "";
        char[] stringList = s.toCharArray();
        int len = stringList.length, left = 0, maxLen = 1;
        boolean[] dp = new boolean[len];
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = len - 1; j >= i; j--) {
                int subLen = j - i + 1;
                boolean headIsTail = stringList[i] == stringList[j];
                dp[j] = headIsTail && (subLen <= 2 || dp[j - 1]);
                if (dp[j] && subLen > maxLen) {
                    maxLen = subLen;
                    left = i;
                }
            }
        }
        return new String(stringList, left, maxLen);
    }
}
