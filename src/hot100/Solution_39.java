package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Solution_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        //一定要排序，否则前几个元素加起来超过了直接跳出了
        Arrays.sort(candidates);
        backtrack(candidates,target,0,res,path);
        return res;
    }

    /**
     * @param candidates  初始传入
     * @param target      初始传入
     * @param index       循环开始的起始位置
     * @param res         结果集
     * @param path        保存每种组合
     */
    private static void backtrack(int[] candidates, int target,int index, List<List<Integer>> res, List<Integer> path) {
        if(target==0){
            //这里一定要new一个新的list，path是会刷新的
            //如果不new，会一直加到res里，导致只会保存最后的结果
            res.add(new ArrayList<>(path));
            return;
        }
        //这里的index的目的是为了避免重复
        //虽然题目说可以无限取同一个元素，但是如果没有index的限制，取之前的元素会导致结果重复（比如2，5和5，2）
        //因此，无论单个元素是否可以重复，只要是组合，并且在同一个集合中取元素，就必须要有index的限制
        for(int i=index;i<candidates.length;i++){
            if(target-candidates[i]<0) break;
            path.add(candidates[i]);
            //隐藏了回溯的过程，target不变
            //因为题目说可以取同一个元素，所以这里i不需要加1
            backtrack(candidates,target-candidates[i],i,res,path);
            path.remove(path.size()-1);
        }
    }
}
