package 代码随想录一刷.动态规划;

/**
 *  416. 分割等和子集
 *  给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

/**
 * 思路，求和的1/2
 * 遍历数组，每个元素都可以加或不加，加上等于和的1/2（正好装满背包），则说明可以分割
 * 背包问题：背包容量1/2*sum，第i个物体的重量是nums[i]，价值是nums[i]（每个元素都可能放入或不放入，性价比都是一样的）
 *
 */
public class Solution_416 {

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        //dp[n]是背包容量为n(最大是sum/2)能装的最大价值
        int[] dp=new int[sum/2+1];
        //先遍历物品
        for(int i=0;i<nums.length;i++) {
            //再遍历背包容量
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if(dp[target] == target)
                return true;
        }
        //当装入的价值等于背包容量的一半，说明可以分割
        return dp[sum / 2] == sum / 2;
    }
}
