package 代码随想录一刷.贪心算法;

/**
 * 跳跃游戏2
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]
 *
 * 思路：每次都尽量跳远，这里的远指当前能跳到的最远距离，类似于最大子数组和
 */
public class Solution_45 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length- 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 到达了当前能跳到的最远距离，更新现在能跳的最远距离，这就是“一步”，但不一定下一步从这开始跳
            // 忽略起点，只管终点
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
