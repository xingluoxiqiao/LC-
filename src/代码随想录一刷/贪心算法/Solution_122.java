package 代码随想录一刷.贪心算法;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * 思路：只要这一天买卖能挣钱，就挣
 */
public class Solution_122 {
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }
}
