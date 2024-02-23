package 代码随想录二刷.动态规划;
//使用最小花费爬楼梯
public class _746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]表示爬到第i阶时所需的最小花费，最终应返回dp[cost.length]
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=Math.min(cost[0],cost[1]);
        for(int i=3;i<cost.length+1;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
