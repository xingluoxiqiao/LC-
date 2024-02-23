package hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Solution_128 {
    //代码随想录.二叉树.贪心算法，排序后遍历如果符合+1，不符合从头开始算
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int temp = 1;
        int res = 1;
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                temp++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                res = Math.max(temp, res);
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
    //哈希表法， （当前元素-1） 不在表中时记录
    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
