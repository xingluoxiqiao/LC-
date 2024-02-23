package 代码随想录一刷.动态规划;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */

//    完全背包，任一种物品可以使用多次
//    与01背包的区别在于遍历顺序不同
//    01背包：外层物品内层背包，并且背包逆序遍历，保证了每个物品只使用一次
//    完全背包：外层物品内层背包，并且背包正序遍历，保证了每个物品可以重复使用

public class Solution_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}
