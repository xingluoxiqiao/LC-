package 代码随想录一刷.动态规划;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class Solution_122 {
    //无限次购买，代码随想录.二叉树.贪心算法
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                sum+=prices[i+1]-prices[i];
            }else {
                continue;
            }
        }
        return sum;
    }
    //代码随想录.二叉树.动态规划
    public int maxProfit2(int[] prices) {
        //dp[i][0]表示第i天不持有股票的最大收益，dp[i][1]表示第i天持有股票的最大收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //没股票，没操作，或者今天卖的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //有股票，没操作，或者今天买的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
