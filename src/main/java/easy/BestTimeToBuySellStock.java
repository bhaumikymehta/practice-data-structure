package easy;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/909174889/
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int minStockValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // first we will update the minstock value with current value from prices
            minStockValue = Math.min(minStockValue, prices[i]);
            // we will see if the current price is greater then minStockValue
            // then we can make profit
            if (minStockValue < prices[i]) {
                maxProfit = Math.max(maxProfit, prices[i] - minStockValue);
            }
        }
        return maxProfit;
    }
}
