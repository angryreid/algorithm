package emma.stackqueue;

import java.util.Stack;

public class _II_739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] nextHighTmp = new int[len];
        Stack<Integer> stack = new Stack();
        for (int t = 0; t < len; t++) {
            while (!stack.isEmpty() && temperatures[t] > temperatures[stack.peek()]) { // Monotonically Decreasing Stack:
                int top = stack.peek();
                nextHighTmp[stack.pop()] = t - top;
            }

            stack.push(t);
        }
        return nextHighTmp;
    }

    /**
     * Next Low Temperature
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] nextLowTmp = new int[len];
        Stack<Integer> minStack = new Stack();
        for (int t = 0; t < len; t++) {
            while (!minStack.isEmpty() && temperatures[t] < temperatures[minStack.peek()]) { // Monotonically Increasing Stack:
                int top = minStack.peek();
                nextLowTmp[minStack.pop()] = t - top;
            }

            minStack.push(t);
        }
        return nextLowTmp;
    }
}
