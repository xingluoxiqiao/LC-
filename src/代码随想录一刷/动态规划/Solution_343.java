package 代码随想录一刷.动态规划;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */

//尽量拆成几个大小相等的数，乘积会更大
public class Solution_343 {
    public int integerBreak(int n) {
        //dp[n]是n能被拆分成的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i - j]));
            }
        }
        return dp[n];
    }
}
