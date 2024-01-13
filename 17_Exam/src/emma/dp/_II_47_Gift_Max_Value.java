package emma.dp;

public class _II_47_Gift_Max_Value {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = frame[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + frame[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + frame[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    private int[][] grid, memo;
    public int jewelleryValue2(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        memo = new int[m][n];
        this.grid = frame;
        return dfs(m-1,n-1);
    }
    private int dfs(int i ,int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(memo[i][j] != 0){
            return memo[i][j] ;
        }
        int left = dfs(i-1,j);
        int top = dfs(i, j -1);
        return memo[i][j] = Math.max(left,top) + grid[i][j];

    }
}
