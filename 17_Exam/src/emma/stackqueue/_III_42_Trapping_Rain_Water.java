package emma.stackqueue;

import java.util.Stack;

public class _III_42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int len = height.length;
        int ans = 0;
        if (len <= 2) return 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int topIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[topIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int leftTopIdx = stack.peek();
                    ans += (Math.min(height[leftTopIdx], height[i]) - height[topIdx]) * (i - leftTopIdx - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }

    // main method
    public static void main(String[] args) {
        _III_42_Trapping_Rain_Water sol = new _III_42_Trapping_Rain_Water();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
        System.out.println(sol.trap(height));
    }
}
