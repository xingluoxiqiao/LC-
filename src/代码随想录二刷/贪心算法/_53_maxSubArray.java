package 代码随想录二刷.贪心算法;
//最大子序和
public class _53_maxSubArray {
    public int maxSubArray(int[] nums) {
        //dp[n]表示以nums[n]结尾时的最大子序和
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        //最终结果并不一定以nums[n]结尾
        return res;
    }
}
