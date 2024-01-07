package emma.strings;

import java.util.HashMap;
import java.util.Map;

public class _III_3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0; // 如果输入的字符串为null，返回0
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组
        Map<Character, Integer> prevIdxes = new HashMap<>(); // 创建一个哈希表，用于存储每个字符最后出现的位置
        prevIdxes.put(chars[0], 0); // 将第一个字符和其位置放入哈希表
        int li = 0; // 初始化最长子串的起始位置
        int max = 1; // 初始化最长子串的长度为1
        for (int i = 1; i < chars.length; i++) { // 从第二个字符开始，遍历字符数组
            char curChar = chars[i]; // 获取当前字符
            Integer pi = prevIdxes.getOrDefault(curChar, -1); // 获取当前字符最后出现的位置，如果没有出现过，返回-1
            if (li <= pi) { // 如果最长子串的起始位置小于或等于当前字符最后出现的位置
                li = pi + 1; // 更新最长子串的起始位置为当前字符最后出现的位置加1
            }
            prevIdxes.put(curChar, i); // 更新当前字符最后出现的位置
            max = Math.max(max, i - li + 1); // 更新最长子串的长度
        }
        return max; // 返回最长子串的长度
    }

    public int lengthOfLongestSubstring2(String s) {
        int ans = 0, n = s.length(); // 初始化最长子串长度为0，n为输入字符串的长度
        if (n == 0) return 0; // 如果字符串长度为0，返回0
        if (n == 1) return 1; // 如果字符串长度为1，返回1
        int start = 0, end = 0; // 初始化滑动窗口的起始和结束位置
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组
        while (end < n) { // 当结束位置小于字符串长度时，继续循环
            // 发现有重复字符时，可以直接把左指针移动到重复字符的下一个位置
            for (int i = start; i < end; i++) { // 从起始位置到结束位置，遍历窗口中的每个字符
                if (chars[i] == chars[end]) { // 如果发现有重复字符
                    start = i + 1; // 将起始位置移动到重复字符的下一个位置
                    break; // 跳出循环
                }
            }
            ans = Math.max(ans, end - start + 1); // 更新最长子串长度
            end++; // 将结束位置向右移动一位
        }
        return ans; // 返回最长子串长度
    }
}
