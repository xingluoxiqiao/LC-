package 代码随想录一刷.动态规划;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]是数组长度为i时以nums[i]为末尾的最长严格递增子序列的长度
        //这是因为加入新元素时，默认将其作为递增子序列的最后一位
        //不用担心它很小，因为下面遍历前面的数字时，如果新元素小的话就不会更新了
        int []dp =new int[nums.length];
        //递增子序列长度最小为1
        Arrays.fill(dp,1);
        int result=0;
        for(int i=0;i<nums.length;i++){
            //循环之前的数，只有长度大于所有的情况，才会最终更新为+1
            for(int j=0; j<i;j++ ){
                //新元素大于以前的元素，才有”可能“更新
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            //记录每个元素作为结尾时的最大长度
            if(dp[i]>result) result=dp[i];
        }
        return result;
    }
    //贪心加二分
    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
