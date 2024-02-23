package 代码随想录一刷.动态规划;

/**
 * 509. 斐波那契数
 */
public class Solution_509 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        //斐波那契数列中下标为n的数为dp[n]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
