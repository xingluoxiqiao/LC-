package 代码随想录一刷.动态规划;

/**
 *  377. 组合总和 Ⅳ
 *  给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 *  请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 */

//    完全背包的遍历顺序决定了所求结果数是组合数还是排列数
//    如果先遍历物品再遍历背包，那么是组合数
//    如果先遍历背包再遍历物品，那么是排列数
    //本题是排列数
public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        //dp[i] 表示和为i的组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i]+= dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
