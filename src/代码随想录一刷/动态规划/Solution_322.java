package 代码随想录一刷.动态规划;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；
 * 以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
//贪心的写法不太行，因为直接使用最大的硬币可能组合不成，还需要回溯
public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i] 表示凑成i元所需的最少硬币个数
        int[] dp = new int[amount + 1];

        //初始化为最大值，后续可被覆盖
        for (int i = 0; i < dp.length; i++) {
            dp[i] =Integer.MAX_VALUE;
        }
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //dp[j - coins[i]] 是初始值时跳过，否则+1后溢出成为int最小值了
                if (dp[j - coins[i]] !=  Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

}
