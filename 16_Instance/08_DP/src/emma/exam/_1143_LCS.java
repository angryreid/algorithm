package emma.exam;

public class _1143_LCS {
    public static int lcs(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        return lcs(nums1, nums1.length, nums2, nums2.length);
    }

    public static int lcs(int[] nums1, int i, int[] num2, int j) {
        if (i == 0 || j == 0) return 0;
        if (nums1[i - 1] == num2[j - 1]) {
            return lcs(nums1, i - 1, num2, j - 1) + 1;
        } else {
            return Math.max(lcs(nums1, i, num2, j - 1), lcs(nums1, i - 1, num2, j));
        }
    }

    public static int lcs2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
    public static void main(String[] args) {
        System.out.println(lcs(new int[]{1,3,5,9,10}, new int[]{1,4,9,10}));
        System.out.println(lcs2(new int[]{1,4,5,9,10}, new int[]{1,4,9,10}));
    }
}
