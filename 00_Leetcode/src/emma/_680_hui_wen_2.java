package emma;

public class _680_hui_wen_2 {
  int del = 0; // 记录删除的字符次数

  public boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        // 不相等的话，若没有删除字符，则删除左边或右边的字符再判断；若删除过一次，则不是回文串
        if (del == 0) {
          del++;
          return validPalindrome(s.substring(i, j)) || validPalindrome(s.substring(i + 1, j + 1));
        }
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
