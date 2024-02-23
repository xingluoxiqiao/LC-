package 代码随想录一刷.动态规划;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0)return 0;
        //一共有2k种状态
        int dp[][] = new int[prices.length][2 * k+1];
        //初始化，奇数买(持有)，偶数卖（不持有）
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                //j是偶数，持有
                //之前买的还是今天买的
                dp[i][j+1] = Math.max(dp[i - 1][j+1], dp[i - 1][j] - prices[i]);
                //之前卖的还是今天卖的
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }

        }
        return dp[prices.length - 1][2 * k];
    }
}
