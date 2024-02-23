package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *  491. 递增子序列
 *  给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */

//本题的去重与之前不太一样，之前的去重数组可以排序，相等的元素会是相邻的，而本题的数组不能排序，所以需要用set集合来去重
public class Solution_491 {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> used =new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty()&&path.get(path.size() - 1)>nums[i]||used.contains(nums[i])) continue;
            used.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
