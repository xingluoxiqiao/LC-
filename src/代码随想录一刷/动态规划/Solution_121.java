package 代码随想录一刷.动态规划;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Solution_121 {
    //一边拿最小值，一边拿最大值
    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        //dp[i][1]表示第i天持有股票的最大利润，dp[i][0]表示第i天不持有股票的最大利润
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //不持有股票，之前卖掉了或者今天卖掉了
            dp[i][0]=
                Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //持有股票，之前买的还是今天买的
            dp[i][1]=
                Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
