package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  78. 子集
 *  给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *  解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        res.add(new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        //没有终止条件是因为子集的元素数量大小是不确定的，元素遍历完时递归自然就结束了
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
