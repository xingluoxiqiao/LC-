package 代码随想录一刷.动态规划;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class Solution_279 {
    public int numSquares(int n) {
        //dp[i] 表示和为i的完全平方数的最少数量
        int [] dp = new int[n + 1];
        //先对n处理，获取大致范围
        int n2 = (int)Math.sqrt(n);
        //初始化为最大值，后续可被覆盖
        for (int i = 0; i < dp.length; i++) {
            dp[i] =Integer.MAX_VALUE;
        }
        dp[0]=0;
        for (int i = 1; i <=n2; i++) {
            for (int j = i*i; j <= n; j++) {
                //dp[j - coins[i]] 是初始值时跳过，否则+1后溢出成为int最小值了
                if (dp[j - i*i] !=  Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
                }
            }
        }
        return dp[n];
    }

}
