class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1, r = 1;
        int len = nums.length;
        if (len <= 1) return len;
        while (r < len) {
            if (nums[r] != nums[l - 1]) {
                nums[l++] = nums[r++];
            } else {
                r++;
            }
        }
        return l;
    }
}