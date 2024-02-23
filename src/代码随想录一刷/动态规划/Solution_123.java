package 代码随想录一刷.动态规划;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class Solution_123 {
    public int maxProfit(int[] prices) {
        //dp[i][0]没买
        //dp[i][1]持有一支
        //dp[i][2]卖了一支
        //dp[i][3]持有两支
        //dp[i][4]卖了两支
        int dp[][] =new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for(int i=1;i<prices.length;i++){
            dp[i][0] = 0;
            //之前买的还是今天买的
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            //之前卖的还是今天卖的
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[prices.length-1][4];
    }
}
