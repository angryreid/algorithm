package emma.exam;

public class MaxSubArr {
    public static int maxSubArr(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArr2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp, max;
        max = dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -2, -3, 4, -1, 2, 1, -5, -4};
        System.out.println(maxSubArr2(nums));
    }
}
