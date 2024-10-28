package prep2024.meta.medium;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class MaxProfitBuyAndSell2 {
    public int maxProfit(int[] prices) {

        int maxProfit2 = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit2 += prices[i] - prices[i - 1];
            }
        }
        return maxProfit2;
    }

    public static void main(String[] args) {
        MaxProfitBuyAndSell2 solution = new MaxProfitBuyAndSell2();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }

}
