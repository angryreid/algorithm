package emma.dp;

public class _II_72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int row = cs1.length + 1;
        int col = cs2.length + 1;
        int[][] dp = new int[row][col];
        dp[0][0] = 0;
        for (int i = 1; i < row; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int delete = 1 + dp[i][j - 1];
                int insert = dp[i - 1][j] + 1;
                int replace = 0;
                if (cs1[i - 1] == cs2[j - 1]) {
                    replace = dp[i - 1][j - 1];
                } else {
                    replace = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(delete, Math.min(insert, replace));
            }
        }
        return dp[row - 1][col - 1];
    }
}
