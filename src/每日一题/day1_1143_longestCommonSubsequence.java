package 每日一题;
//最长公共子序列
public class day1_1143_longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        //dp[i][j]是遍历到text1i和text2j时的最长公共子序列长度
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char c1=text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char c2=text2.charAt(j-1);
                if(c2==c1){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
