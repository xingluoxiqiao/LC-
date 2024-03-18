package 每日一题;
//合并后数组的最大元素
//给你一个下标从 0 开始、由正整数组成的数组 nums 。
//        你可以在数组上执行下述操作 任意 次：
//        选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。
//        将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
//        返回你可以从最终数组中获得的 最大 元素的值


//倒序遍历+贪心算法
public class day9_2789_maxArrayValue {
    public long maxArrayValue(int[] nums) {
        long sum=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            sum=nums[i]<=sum?nums[i]+sum:nums[i];
        }
        return sum;
    }
}
