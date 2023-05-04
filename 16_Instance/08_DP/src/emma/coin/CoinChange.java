package emma.coin;

 public class CoinChange {
    public static void main(String[] args) {
        int money = 41;
        System.out.println(coins(money));
        System.out.println(coins2(money));

    }

    static int coins(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coins(n - 25), coins(n - 20));
        int min2 = Math.min(coins(n - 5), coins(n - 1));
        return Math.min(min1, min2) + 1;
    }
     static int coins2(int n) {
         if (n < 1) return -1;
         int[] dp = new int[n + 1];
         int[] faces = {1, 5, 20, 25};
         for (int face :
                 faces) {
             if (n < face) continue;
             dp[face] = 1;
         }
         dp[1] = dp[5] = dp[20] = dp[25] = 1;
         return coins2(n, dp);
     }

     static int coins2(int n, int[] dp) {
         if (n < 1) return Integer.MAX_VALUE;
         if (dp[n] == 0) {
             int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
             int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
             dp[n] = Math.min(min1, min2) + 1;
         }
         return dp[n];
     }
}
