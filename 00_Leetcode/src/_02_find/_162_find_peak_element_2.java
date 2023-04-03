package _02_find;

public class _162_find_peak_element_2 {
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r ) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r  = m;
            }
        }
        return r;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
}
