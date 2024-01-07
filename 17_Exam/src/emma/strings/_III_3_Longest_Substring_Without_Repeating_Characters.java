package emma.strings;

import java.util.HashMap;
import java.util.Map;

public class _III_3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> prevIdxes = new HashMap<>();
        prevIdxes.put(chars[0], 0);
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            char curChar = chars[i];
            Integer pi = prevIdxes.getOrDefault(curChar, -1);
            if (li <= pi) {
                li = pi + 1;
            }
            prevIdxes.put(curChar, i);
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
