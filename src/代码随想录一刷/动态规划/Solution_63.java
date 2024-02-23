package 代码随想录一刷.动态规划;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
//和不同路径那道题几乎一样，只是多了一个障碍物，所以只要在原来的基础上加一个判断即可
//并且初始化时也需要注意，如果障碍物在最上或最下一行，那么它后面的所有格子都初始化为0
public class Solution_63 {
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
