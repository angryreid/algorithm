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
        return 0;
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
