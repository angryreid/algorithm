package emma.dp;

public class _I_121_Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;
        int[] profits = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            profits[i] = prices[i + 1] - prices[i];
        }
        int[] dp = new int[len - 1];
        dp[0] = profits[0];
        int max = Math.max(0, dp[0]);
        for (int i = 1; i < len - 1; i++) {
            int prev = dp[i - 1];
            if (prev > 0) {
                dp[i] = prev + profits[i];
            } else {
                dp[i] = profits[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;
        int[] profits = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            profits[i] = prices[i + 1] - prices[i];
        }
        int dp = profits[0];
        int max = Math.max(0, dp);
        for (int i = 1; i < len - 1; i++) {
            int prev = dp;
            if (prev > 0) {
                dp = prev + profits[i];
            } else {
                dp = profits[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }


    public int maxProfit4(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;
        int dp = prices[1] - prices[0];
        int max = Math.max(0, dp);
        for (int i = 1; i < len - 1; i++) {
            int prev = dp;
            int profit = prices[i + 1] - prices[i];
            if (prev > 0) {
                dp = prev + profit;
            } else {
                dp = profit;
            }
            max = Math.max(max, dp);
        }
        return max;
    }

//    var maxProfit = function(prices) {
//        if (prices.length == 1) return 0;
//        let min = prices[0];
//        let max = 0;
//        for (let price of prices) {
//            if (price <= min) {
//                min = price;
//            } else {
//                max = Math.max(max, price - min);
//            }
//        }
//        return max;
//    };
}
