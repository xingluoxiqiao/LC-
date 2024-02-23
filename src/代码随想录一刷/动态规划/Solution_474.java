package 代码随想录一刷.动态规划;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
//背包容量：两个维度，m，n
public class Solution_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[m][n]表示最多有m个0和n个1的子集的最大长度
        int dp[][]= new int[m+1][n+1];
        dp[0][0]=0;
        //先获取0和1的个数(遍历物品)
        int  zero,one;
        for(String s:strs) {
            zero=0;
            one=0;
            for (char c : s.toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
