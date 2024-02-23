package 代码随想录一刷.动态规划;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class Solution_718{
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]是以nums1[i],nums2[j]结尾的最长公共字数组长度
        int [][] dp=new int[nums1.length][nums2.length];
        int res=0;
        //初始化，由递推公式知当前值由左上角值得来，所以需初始化第一行和第一列
        if(nums1[0]==nums2[0]) {
            dp[0][0] = 1;
            res = 1;
        }else dp[0][0]=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==nums2[0]) {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==nums1[0]) {
                dp[0][i] = 1;
                res = 1;
            }
        }
        for(int i=1;i<nums1.length;i++){
            for (int j =1;j<nums2.length;j++){
                if(nums1[i]==nums2[j]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                res=dp[i][j]>res?dp[i][j]:res;
            }

        }
        return res;
    }

    //代码更简洁，但其实效率差不多，上面的要自己想初始化
    public int findLength2(int[] nums1, int[] nums2) {
        int result = 0;
        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        //相当于上面的方法将整个数组向右下角平移一格
        //所以最上行和最左列自动初始化成为符合定义的结果（全是0），不用再另外初始化也可以推出右下，从而得到整个dp数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
