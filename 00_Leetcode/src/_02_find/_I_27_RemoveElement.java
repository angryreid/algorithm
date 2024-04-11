class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        int len = nums.length;
        if (len == 0 || (len == 1 && nums[0] == val)) {
            return 0;
        }
        while (r < len) {
            if (nums[r] != val) {
                nums[l++] = nums[r++];
            } else {
                r++;
            }
        }
        return l;
    }
}