package emma;

import java.util.Arrays;
import java.util.Collections;

public class _151_ReverseWords {
  public static String reverseWords2(String s) {
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }

  public static String reverseWords(String s) {
    if (s == null)
      return null;
    char[] strArr = s.toCharArray();
    int n = strArr.length;
    // 翻转这个数组
    reverse(strArr, 0, n - 1);
    System.out.println(new String(strArr));
    // 翻转每一个单词
    singelWordReverse(strArr, n);
    System.out.println(new String(strArr));
    // 去除多余的空格
    return cleanSpace(strArr, n);
  }

  private static void reverse(char[] strArr, int i, int j) {// reverse all
    while (i < j) {
      char t = strArr[i];
      strArr[i++] = strArr[j];
      strArr[j--] = t;
    }
  }

  private static void singelWordReverse(char[] strArr, int n) {
    int i = 0, j = 0;
    while (j < n) {
      while (i < n && strArr[i] == ' ')// 找到单词首字母位置
        i++;
      j = i;
      while (j < n && strArr[j] != ' ')// 找到单词末尾位置
        j++;
      reverse(strArr, i, j - 1);
      i = j;
    }
  }

  private static String cleanSpace(char[] strArr, int n) {
    int i = 0, j = 0;
    while (j < n) {
      while (j < n && strArr[j] == ' ')// 找到第一个单词开始位置
        j++;
      while (j < n && strArr[j] != ' ')// 单词整体向前移动
        strArr[i++] = strArr[j++];
      while (j < n && strArr[j] == ' ')// 找到下一个单词的位置
        j++;
      if (j < n)
        strArr[i++] = ' ';// 每个单词后拼接一个空格
    }
    return new String(strArr).substring(0, i);// 返回最后i的位置
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(reverseWords("   hello world! "));
  }

}
