package 代码随想录一刷.动态规划;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution_309 {
    public int maxProfit(int[] prices) {
        //加一个冷冻期的状态即可
        //dp[i]表示第 i天结束之后的「累计最大收益」
        //目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 dp[i][0]
        //目前持有一支股票，对应的「累计最大收益」记为dp[i][1]
        //目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 dp[i][2]
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天不持有股票且不处于冷冻期
            //今天没有股票并且不是冷冻期，昨天只能是本来就没有或是冷冻期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            //持有股票，昨天本来就有或者今天买的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //今天结束之后是冷冻期，表明今天卖了
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        //打印dp数组
        for (int[] ints : dp){
            for (int anInt : ints){
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
