package _01_two_pointer;

public class _II_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int max = 0;
        while (l < r) {
            int minH = height[l] < height[r] ? height[l++] : height[r--];
            max = Math.max(max, minH * (r - l + 1));
        }
        return max;
    }
}
