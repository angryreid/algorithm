package emma;

public class Main {
    static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        for (int i = 1; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        return maxSubArray3(nums, 0, len);
    }

    static int maxSubArray3(int[] nums, int left, int right) { // [left, right)
        if (right - left < 2) return nums[left];
        int mid = (left + right) >> 1;
        // [left, mid)
        int leftMax = nums[mid - 1];
        int leftSum = leftMax;
        for (int i = mid - 2; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        // [mid, right)
        int rightMax  = nums[mid];
        int rightSum = rightMax;
        for (int i = mid + 1; i < right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(
                (rightMax + leftMax),
                Math.max(
                        maxSubArray3(nums, left, mid),
                        maxSubArray3(nums, mid, right)));

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }
}
