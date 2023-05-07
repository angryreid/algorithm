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

    public static int lcs3(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int preRow = (i - 1) % 2;
            int row = i % 2; // i & 1
            for (int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[row][j] = dp[preRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[row][j - 1], dp[preRow][j]);
                }
            }
        }
        return dp[nums1.length % 2][nums2.length];
    }

    public static int lcs4(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[nums2.length];
    }

    public static void main(String[] args) {
        System.out.println(lcs(new int[]{1,3,5,9,10}, new int[]{1,4,9,10}));
        System.out.println(lcs2(new int[]{1,4,5,9,10}, new int[]{1,4,9,10}));
        System.out.println(lcs3(new int[]{1,2,4,5,9,10}, new int[]{1,4,9,10}));
        System.out.println(lcs4(new int[]{1,2,4,5,9,10}, new int[]{1,4,9,10}));
    }
}
