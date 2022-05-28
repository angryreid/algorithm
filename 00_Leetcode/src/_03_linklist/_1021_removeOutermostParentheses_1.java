package _03_linklist;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.cn/problems/remove-outermost-parentheses/submissions/
public class _1021_removeOutermostParentheses_1 {

//    public static String removeOuterParentheses(String s) {
//        Queue<Character> queue = new LinkedList<>();
//        String result = "";
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                queue.offer(c);
//            } else {
//                queue.poll();
//            }
//            // Save string
//            if (queue.isEmpty()) {
//                if ((i - start) > 1) {
//                    String subStr = s.substring(start + 1, i);
//                    result += subStr;
//                }
//                start = i + 1;// It's empty at here.
//            }
//        }
//        return result;
//    }
public static String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    int level = 0;
    for (char c : s.toCharArray()) {
        if (c == ')') --level;
        if (level >= 1) sb.append(c);
        if (c == '(') ++level;
    }
    return sb.toString();
}
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(())()"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
