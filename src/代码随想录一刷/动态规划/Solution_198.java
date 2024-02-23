package 代码随想录一刷.动态规划;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */

//每间房间的状态（是否”可以“被偷）由前两间决定
public class Solution_198 {
    public int rob(int[] nums) {
        //dp[m][0]表示第m间房子不偷，dp[m][1]表示第m间房子偷
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1;i < nums.length;i++){
            //当前不偷，则最大值等于前一个不偷的最大值
            //当前偷，则最大值等于前一个偷的最大值+当前值
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
