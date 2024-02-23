package 代码随想录一刷.动态规划;

import java.util.Arrays;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，
 * 如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列
 */
public class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {
        //dp[i]表示前i个元素中最长连续递增子序列长度
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int result=1;
        for (int i=1;i<nums.length;i++){
                if(nums[i]>nums[i-1]){
                    dp[i]=Math.max(dp[i],dp[i-1]+1);
                }else{
                    dp[i]=1;
                }
            result=dp[i]>result?dp[i]:result;
        }
        return result;
    }
}
