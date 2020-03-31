package emma;

public class _5_LongestPalindromicSubstring {

  /**
   * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
   * https://leetcode-cn.com/problems/longest-palindromic-substring/
   * 
   * @param s
   * @return 输入: "babad" 输出: "bab" 注意: "aba"也是一个有效答案。
   */
  public static String longestPalindrome(String s) {
    if (s.equals(""))
      return "";
    String origin = s;
    String reverse = new StringBuffer(s).reverse().toString();
    int length = s.length();
    int[] arr = new int[length];
    int maxLen = 0;
    int maxEnd = 0;
    for (int i = 0; i < length; i++)
      for (int j = length - 1; j >= 0; j--) {
        if (origin.charAt(i) == reverse.charAt(j)) {
          if (i == 0 || j == 0) {
            arr[j] = 1;
          } else {
            arr[j] = arr[j - 1] + 1;
          }
        } else {
          arr[j] = 0;
        }
        if (arr[j] > maxLen) {
          int beforeRev = length - 1 - j;
          if (beforeRev + arr[j] - 1 == i) {
            maxLen = arr[j];
            maxEnd = i;
          }

        }
      }
    return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
  }

  /**
   * 暴力破解法 列举所有的子串，判断是否为回文串，保存最长的回文串。
   * 
   * @param s
   * @return 时间复杂度：两层都是for循环O(n^2), for循环里边判断是否是回文O(n),so the complexity is O(n^3)
   *         空间复杂度: O(1)
   */
  public static String longestPalindrome2(String s) {
    String ans = "";
    int max = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      for (int j = 0; j <= len; j++) {
        String test = s.substring(i, j);
        if (isPalinddromic(test) && test.length() > max) {
          ans = s.substring(i, j);
          max = Math.max(max, ans.length());
        }
      }
    }
    return ans;
  }

  public static boolean isPalinddromic(String s) {
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String string = "aacdefcaa";
    System.out.println(longestPalindrome(string));// "aa"
  }
}
