package 代码随想录二刷.动态规划;
//不同路径
public class _62_uniquePaths {
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示走到（i，j）时的不同路径数，最终返回dp[m-1][n-1]
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                // 到达（i，j）总共有dp[i-1][j] 和 dp[i][j-1] 种方法
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
