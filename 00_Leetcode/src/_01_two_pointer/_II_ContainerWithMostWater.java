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
}
