package _01_two_pointer;

public class _II_ContainerWithMostWater {
    // Method to find the maximum area of water that can be contained
    public int maxArea(int[] height) {
        // Get the length of the height array
        int len = height.length;
        // Initialize two pointers at the two ends of the array
        int l = 0, r = len - 1;
        // Initialize the maximum area to 0
        int max = 0;
        // While the two pointers have not met
        while (l < r) {
            // Update the maximum area with the maximum of the current maximum area and the area of the current container
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            // If the height at the left pointer is greater than the height at the right pointer, decrement the right pointer
            if (height[l] > height[r]) {
                r--;
            // Otherwise, increment the left pointer
            } else {
                l++;
            }
        }
        // Return the maximum area
        return max;
    }

    // Another method to find the maximum area of water that can be contained
    public int maxArea2(int[] height) {
        // Get the length of the height array
        int len = height.length;
        // Initialize two pointers at the two ends of the array
        int l = 0, r = len - 1;
        // Initialize the maximum area to 0
        int max = 0;
        // While the two pointers have not met
        while (l < r) {
            // Get the minimum height between the two pointers and move the pointer with the smaller height
            int minH = height[l] < height[r] ? height[l++] : height[r--];
            // Update the maximum area with the maximum of the current maximum area and the area of the current container
            max = Math.max(max, minH * (r - l + 1));
        }
        // Return the maximum area
        return max;
    }

    // Yet another method to find the maximum area of water that can be contained
    public int maxArea3(int[] height) {
        // Get the length of the height array
        int len = height.length;
        // Initialize two pointers at the two ends of the array
        int l = 0, r = len - 1;
        // Initialize the maximum area to 0
        int max = 0;
        // While the two pointers have not met
        while (l < r) {
            // Get the heights at the two pointers
            int lh = height[l], rh = height[r];
            // Update the maximum area with the maximum of the current maximum area and the area of the current container
            max = Math.max(max, Math.min(lh, rh) * (r - l));
            // If the height at the left pointer is greater than the height at the right pointer
            if (lh > rh) {
                // Decrement the right pointer
                r--;
                // While the right pointer is greater than the left pointer and the height at the right pointer is less than or equal to the previous height at the right pointer, decrement the right pointer
                while (r > l && height[r] <= rh) r--;
            // Otherwise
            } else {
                // Increment the left pointer
                l++;
                // While the left pointer is less than the right pointer and the height at the left pointer is less than or equal to the previous height at the left pointer, increment the left pointer
                while (l < r && height[l] <= lh) l++;
            }
        }
        // Return the maximum area
        return max;
    }
}