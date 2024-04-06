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

    public String longestPalindrome3(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        int len = cs.length, l = 0, maxLen = 1;
        int i = 0;
        while (i < len) {
            int li = i - 1, r = i;
            while (++r < len && cs[i] == cs[r]);
            i = r;
            while (li >= 0 && r < len && cs[li] == cs[r]) {
                li--;
                r++;
            }
            li++;
            int subLen = r - li;
            if (subLen > maxLen) {
                maxLen = subLen;
                l = li;
            }
        }
        return new String(cs, l, maxLen);
    }

    static char[] processManacherString(char[] chars, int len) {
        int csLen = 2 * len + 3;
        char[] cs = new char[csLen];
        cs[0] = '^';
        cs[1] = '#';
        cs[csLen - 1] = '$';
        for (int i = 0; i < len; i++) {
            int idx = (i + 1) * 2;
            cs[idx] = chars[i];
            cs[idx + 1] = '#';
        }
        return cs;
    }

    static public String longestPalindrome4(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (len <= 1) return s;
        char[] mncs = processManacherString(cs, len);
        int[] m = new int[mncs.length];
        m[2] = 1;
        int c = 1, r = 1, last = m.length - 2;
        int idx = 0, maxLen = 0;
        for (int i = 2; i < last; i++) {
            if (r > i) {
                int li = (c << 1) - i;
                if (i + m[li] <= r) {
                    m[i] = m[li];
                } else {
                    m[i] = r - i;
                }
            }
            while (mncs[i + m[i] + 1] == mncs[i - m[i] - 1]) {
                m[i]++;
            }
            if (i + m[i] > r) {
                c = i;
                r = i + m[i];
            }
            if (m[i] > maxLen) {
                maxLen = m[i];
                idx = i;
            }
        }
        return new String(cs, (idx - maxLen) >> 1, maxLen);
    }

    public static void main(String[] args) {
        String s = "abcaabaa"; // ^#a#b#c#a#a#b#a#a#$
        System.out.println(longestPalindrome4(s));;
    }
}
