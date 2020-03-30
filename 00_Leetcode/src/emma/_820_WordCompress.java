package emma;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _820_WordCompress {

  /**
   * Violence save suffix
   * 
   * @param words
   * @return
   */
  public static int minimumLengthEncoding(String[] words) {
    int ans = 0;
    Set<String> set = new HashSet<String>(Arrays.asList(words));
    for (String word : words) {
      for (int i = 1; i < word.length(); i++) {
        set.remove(word.substring(i));
      }
    }
    System.out.println(set);
    for (String s : set) {
      ans += s.length() + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] strArr = { "time", "me", "bell" };
    String[] strArr2 = { "time", "me" }; // error 8 - 5
    System.out.println(minimumLengthEncoding(strArr2));
  }
}
