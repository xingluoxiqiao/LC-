package 代码随想录一刷.动态规划;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class Solution_62 {
    public int uniquePaths(int m, int n) {
        // 到达（i，j）总共有dp[i][j] 种方法
        int[][] dp = new int[m][n];
        // 初始化，只能向下或右，因此需初始化最左列和最上行
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                // 到达（i，j）总共有dp[i-1][j] 和 dp[i][j-1] 种方法
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
