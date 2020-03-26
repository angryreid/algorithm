package emma;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('(', ')');
    map.put('{', '}');
    map.put('[', ']');
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty())
          return false;
        if (stack.size() > s.length() / 2)
          return false;
        char left = stack.pop();
        if (map.get(left) != c)
          return false;
      }
    }
    return stack.isEmpty();
  }

  public static int longestValidParentheses(String s) { // 32
    int maxans = 0;
    java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty())
          stack.push(i);
        else {
          maxans = Math.max(maxans, i - stack.peek());
        }
      }
    }
    return maxans;

  }

  public static void main(String[] args) {
//    Stack<Integer> stack = new Stack<Integer>();
//    stack.push(1);
//    stack.push(2);
//    stack.push(3);
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());
    System.out.println(longestValidParentheses(")())((())"));
    ;
  }
}
