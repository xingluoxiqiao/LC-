package 代码随想录一刷.动态规划;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
//    每个数有两种可能，加或减，所以可以分成两组，分别计算，然后相加，记加集合为left，减集合为right
//    则left-right=target，left+right=sum，
//    所以left=(sum+target)/2是一个固定的数，
//    问题就变成了，有多少种组合，使得和为left，即求组合数
//    可以用回溯，也可以用动规
public class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        //全加都达不到，直接返回0，left=（sum+target）/2必须是整数
        if(sum<target||(sum+target)%2==1) return 0;
        //全减都达不到，直接返回0
        if(target<0&&sum<-target) return 0;
        int left=(sum+target)/2;
        if(left<0) left=-left;
        //dp[n]是装满n这么大的背包有几种方法
        int [] dp=new int[left+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=left;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[left];
    }
}
