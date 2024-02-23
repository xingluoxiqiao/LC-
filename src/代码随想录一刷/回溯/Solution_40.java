package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和||
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */

//本题的关键在于解集不能包含重复的组合
//当candidates中有重复的数字时，虽然在一个解集中可以同时使用，但是不能在不同的解集中分别使用
//如[10,1,2,7,6,1,5]中的两个1，可以是[1,1,6]，但不能前面的1是[1,7]，后面的1也是[1,7]
    //使用used数组去重的思路https://www.programmercarl.com/0040.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CII.html#%E6%80%9D%E8%B7%AF

//    理解树型结构的层和枝
public class Solution_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        //一定要排序，否则前几个元素加起来超过了直接跳出了
        Arrays.sort(candidates);
        backtrack(candidates,target,0,res,path);
        return res;
    }

    private static void backtrack(int[] candidates, int target,int index, List<List<Integer>> res, List<Integer> path) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            //这里对相等数字的不同解集进行了去重,排序后相等的数字相邻，此时应该直接跳过，因为它们同时出现在某个解集中的情况已经在前面遍历到了
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if(target-candidates[i]<0) break;
            path.add(candidates[i]);
            //隐藏了回溯的过程，target不变
            //index变为i+1，不能重复使用同一个数字
            backtrack(candidates,target-candidates[i],i+1,res,path);
            path.remove(path.size()-1);
        }
    }
}
