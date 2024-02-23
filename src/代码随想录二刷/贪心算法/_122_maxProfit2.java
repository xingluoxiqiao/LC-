package 代码随想录二刷.贪心算法;
//买卖股票的最佳时机2
public class _122_maxProfit2 {
    //无限次买卖，但只能同时持有一支

    //贪心算法
    public int maxProfit2(int[] prices) {
        int res=0;
        //遍历一遍数组，只要有利润的时候就加上
        for(int i=1;i<prices.length;i++){
            int diff=prices[i]-prices[i-1];
            res+=diff>0?diff:0;
        }
        return res;
    }

    //动态规划
    public int maxProfit2ByDP(int[] prices) {
        //dp[0][i]表示第i天持有股票的最大值
        //dp[1][i]表示第i天不持有股票的最大值
        int[][] dp=new int[2][prices.length];
        dp[0][0]=-prices[0];
        dp[1][0]=0;
        for(int i=1;i<prices.length;i++){
            //持有股票，昨天本来就有，今天买的
            dp[0][i]=Math.max(dp[1][i-1]-prices[i],dp[0][i-1]);
            //不持有股票，昨天本来就没有，今天卖的
            dp[1][i]=Math.max(dp[0][i-1]+prices[i],dp[1][i-1]);
        }
        return dp[1][prices.length-1];
    }
}
