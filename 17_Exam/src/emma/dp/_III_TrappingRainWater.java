package emma.dp;

public class _III_TrappingRainWater {
    public int maxArea(int[] height) {
        if (height == null)
            return 0;
        int len = height.length;
        if (len <= 2)
            return 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min <= height[i])
                continue;
            res += min - height[i];
        }
        return res;
    }
    public int maxArea2(int[] height) {
        if (height == null)
            return 0;
        int len = height.length;
        if (len <= 2)
            return 0;
        int[] rightMax = new int[len];
        int res = 0;
        for (int i = len - 2; i >= 1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int leftMax = 0;
        for (int i = 1; i < len - 1; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            int min = Math.min(leftMax, rightMax[i]);
            if (min <= height[i])
                continue;
            res += min - height[i];
        }
        return res;
    }
}
