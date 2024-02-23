package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  46. 全排列
 *  给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *  不含重复数字使得只需要在track中判断即可，否则需要使用hashset或哈希表
 */
public class Solution_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,nums,new ArrayList<>());
        return res;
    }
    private static void backtrack(List<List<Integer>> res,int[] nums,List<Integer> track){
        if(track.size()==nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(res,nums,track);
            track.remove(track.size()-1);
        }
    }
}
