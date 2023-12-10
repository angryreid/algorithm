package emma.pointer;

public class _II_75_sort_colors {
    // LeetCode 75 link: https://leetcode.com/problems/sort-colors/

    // scanning idx -> 1: skip
    // scanning idx -> 0: shift with left
    // scanning idx -> 2: shift with right -> check scanning idx value again.
    public void sortColors(int[] nums) { // Define the method that takes an array of integers as input
      int i = 0; // Initialize a pointer for the current element
      int l = 0; // Initialize a pointer for the next position of 0
      int r = nums.length - 1; // Initialize a pointer for the next position of 2

      while (i <= r) { // While there are unprocessed elements
        int v = nums[i]; // Get the value of the current element

        if (v == 0) { // If the value is 0
          swap(nums, i++, l++); // Swap the current element with the next position of 0, and move both pointers
        } else if (v == 1) { // If the value is 1
          i++; // Move the pointer of the current element
        } else { // If the value is 2
          swap(nums, i, r--); // Swap the current element with the next position of 2, and move the pointer of the next position of 2
        }
      }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }

    // create main function to test the solution
    public static void main(String[] args) {
        // write test code here and use assert to do self-check
        _II_75_sort_colors solution = new _II_75_sort_colors();
        int[] nums = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums);
        assert nums[0] == 0;
        assert nums[1] == 0;
        assert nums[2] == 1;
        assert nums[3] == 1;
        assert nums[4] == 2;
        assert nums[5] == 2;

        // get calss name
        String className = _II_75_sort_colors.class.getName();
        // write output line with test class name inside the string
        System.out.println(className + " self check passed!");
    }

}
