package 代码随想录二刷.动态规划;
//不同路径2
public class _63_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //起点或终点有障碍物，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        // 到达（i，j）总共有dp[i][j] 种方法
        int[][] dp = new int[m][n];
        // 初始化，只能向下或右，因此需初始化最左列和最上行
        for (int i = 0; i < m&&obstacleGrid[i][0]==0; i++) {
            dp[i][0] = 1;
        }
        for(int j=0;j<n&&obstacleGrid[0][j]==0;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                // 到达（i，j）总共有dp[i-1][j] 和 dp[i][j-1] 种方法
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m-1][n-1];
    }
}
