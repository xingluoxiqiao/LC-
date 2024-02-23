package 代码随想录一刷.回溯;

import java.util.*;

/**
 *  47. 全排列 II
 *  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *  本题的关键就在于给结果集去重，使用used数组来标记某个数字是否被使用过，
 *  相等的数字必须都被使用但不能重复使用，即使用过的数字不能再次使用。
 *  used数组既保证了每个数字只使用一次，又保证了每个数字不会被重复使用。
 *  相等的数字也不会导出相同的结果集，因为相等的数字不会在同一树层（同一树枝）被使用。
 */
public class Solution_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);;
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);;
        backtrack(res,nums,new ArrayList<>(),used);
        return res;
    }
    private static void backtrack(List<List<Integer>> res,int[] nums,List<Integer> track,boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //这里used[i - 1] == false和used[i-1]==true均可，前者是在树层上去重，后者是树枝上
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            if (used[i] == false) {
                track.add(nums[i]);
                used[i] = true;
                backtrack(res, nums, track, used);
                track.remove(track.size() - 1);
                used[i] = false;
            }
        }
    }
}
