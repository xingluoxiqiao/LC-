package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。
 * 也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分 。
 */

//代码随想录.二叉树.动态规划+双端队列
public class Solution_1696 {
    public int maxResult(int[] nums, int k) {
        //dp[i]表示跳到第i格时的最大得分
        int n=nums.length;
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        //队列中存储数组下标
        Deque<Integer> queue=new ArrayDeque<>();
        queue.offerLast(0);
        for(int i=1;i<nums.length;i++){
            //数组下标小于队列头时移除
            while(queue.peekFirst()<i-k){
                queue.pollFirst();
            }
            dp[i]=dp[queue.peekFirst()]+nums[i];
            //维护一个递减（下标一定是递增，这里的递减指的是下标对应的值）的队列
            //保证队列头是当前能跳到的步数下得分最大的
            //如果前面的步数下得分小于等于当前步数下得分，则移除
            while( (!queue.isEmpty()) && (dp[queue.peekLast()])<=dp[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n-1];
    }
}
