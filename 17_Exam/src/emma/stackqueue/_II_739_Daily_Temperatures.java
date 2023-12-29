package emma.stackqueue;

import java.util.Stack;

public class _II_739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] nextHighTmp = new int[len];
        Stack<Integer> stack = new Stack();
        for(int t = 0; t < len; t++) {
            while(!stack.isEmpty() && temperatures[t] > temperatures[stack.peek()]) {
                int top = stack.peek();
                nextHighTmp[stack.pop()] = t - top;
            }

            stack.push(t);
        }
        return nextHighTmp;
    }
}
