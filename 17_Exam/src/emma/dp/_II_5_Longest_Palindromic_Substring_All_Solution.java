package emma.dp;

public class _II_5_Longest_Palindromic_Substring_All_Solution {
    /**
     * Nick's solution (Dynamic Programming)
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
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

    /**
     * Dynamic Programming (Space Optimized)
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
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

    /**
     * Dynamic Programming (Space Optimized) 
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
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

    /**
     * Expand Around Center
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^2)
     * Space complexity: O(1)   
     * Reference: https://leetcode.com/problems/longest-palindromic-substring/solution/
     */
    public String longestPalindrome4(String s) {
        if (s == null) return null;
        char[] stringList = s.toCharArray();
        int len = stringList.length, left = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(stringList, i, i);// odd length， i is the center
            int len2 = expandAroundCenter(stringList, i, i + 1);// even length， i and i + 1 are the center
            int max = Math.max(len1, len2);
            if (max > maxLen) {
                maxLen = max;
                left = i - (max - 1) / 2; // (max - 1) / 2 is the half of the length of the palindrome
            }
        }
        return new String(stringList, left, maxLen);
    }

    private int expandAroundCenter(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1; // right - left + 1 - 2， -2 is to remove the extra 2 steps
    }

    /**
     * Expand Around Center
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^2)
     * Space complexity: O(1)   
     * Reference: https://leetcode.com/problems/longest-palindromic-substring/solution/
     */
    public String longestPalindrome4_dot_1(String s) {
        if (s == null) return null;
        char[] stringList = s.toCharArray();
        int len = stringList.length, left = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            // If remaining string length is less than maxLen, break the loop
            if (len - i <= maxLen / 2) {
                break;
            }
            int len1 = expandAroundCenter(stringList, i, i); // odd length, i is the center
            int len2 = expandAroundCenter(stringList, i, i + 1); // even length, i and i + 1 are the center
            int max = Math.max(len1, len2);
            if (max > maxLen) {
                maxLen = max;
                left = i - (max - 1) / 2; // (max - 1) / 2 is the half of the length of the palindrome
            }
        }
        return new String(stringList, left, maxLen);
    }

    /**
     * Enhancement based on expand Around Center
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * Reference: https://leetcode.com/problems/longest-palindromic-substring/solution/
     */
    public String longestPalindrome4_dot_2(String s) {
        if (s == null) return null;
        char[] stringList = s.toCharArray();
        int len = stringList.length, left = 0, maxLen = 1;
        int i = 0;
        while (i < len) {
            int start = i, end = i;
            // Skip duplicate characters.
            while (end < len - 1 && stringList[end] == stringList[end + 1]) {
                end++;
            }
            i = end + 1; // Move i to the next different character.
            int len1 = expandAroundCenter(stringList, start, end); // odd or even length, start to end is the center
            if (len1 > maxLen) {
                maxLen = len1;
                left = start - (len1 - end + start - 1) / 2;// (len1 - end + start - 1) / 2 is the half of the length of the palindrome
            }
        }
        return new String(stringList, left, maxLen);
    }

    public String longestPalindrome4_dot_3(String s) {
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

    /**
     * Manacher's Algorithm
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n)
     * Space complexity: O(n)
     * Reference: https://www.felix021.com/blog/read.php?2040
     */
    public String longestPalindrome5(String s) {
        if (s == null) return null;
        char[] stringList = s.toCharArray();
        int len = stringList.length;
        if (len == 0) return "";
        char[] newString = new char[2 * len + 1];
        for (int i = 0; i < len; i++) {
            newString[2 * i] = '#';
            newString[2 * i + 1] = stringList[i];
        }
        newString[2 * len] = '#';
        int[] p = new int[2 * len + 1];
        int center = 0, right = 0;
        for (int i = 1; i < 2 * len; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            int left = i - p[i] - 1, right1 = i + p[i] + 1;
            while (left >= 0 && right1 < 2 * len + 1 && newString[left] == newString[right1]) {
                p[i]++;
                left--;
                right1++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        int maxLen = 0, centerIndex = 0;
        for (int i = 0; i < 2 * len + 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    /**
     * violent solution
     * @param s input string
     * @return longest palindromic substring
     * Time complexity: O(n^3)
     * Space complexity: O(1)
     */
    public String longestPalindrome6(String s) {
        if (s == null) return null;
        char[] stringList = s.toCharArray();
        int len = stringList.length, left = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(stringList, i, j) && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    left = i;
                }
            }
        }
        return new String(stringList, left, maxLen);
    }

    private boolean isPalindrome(char[] s, int left, int right) {
        while (left < right) {
            if (s[left++] != s[right--]) return false;
        }
        return true;
    }
}
