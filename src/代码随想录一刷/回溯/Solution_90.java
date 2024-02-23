package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  90. 子集 II
 *  给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *  解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */

//和之前的一道题有些类似，相等的元素形成的子集是相同的
public class Solution_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        res.add(new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        for(int i = start; i < nums.length; i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }

    }

}
