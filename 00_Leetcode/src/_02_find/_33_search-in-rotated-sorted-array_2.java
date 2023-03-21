class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[r] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int first = nums[0];
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (first <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (first == target) return 0;
        if (first > target) {
            r = nums.length - 1;
        } else {
            l = 0;
        }
        while(l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}