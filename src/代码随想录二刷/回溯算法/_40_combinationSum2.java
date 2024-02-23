package 代码随想录二刷.回溯算法;

import java.util.*;

//组合总和2
public class _40_combinationSum2 {
    //这是一种解法，使用set来去重，但是只是对最终结果去重，并没有影响递归时的逻辑（没有实质的剪枝）
    //因此在极端用例下，可能出现超时
    public List<List<Integer>> combinationSum2BySet(int[] candidates, int target) {
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> path=new ArrayList<>();
        //一定要排序，否则前几个元素加起来超过了直接跳出了
        Arrays.sort(candidates);
        backtrack(candidates,target,0,res,path);
        List<List<Integer>> ans=new ArrayList<>(res);
        return ans;
    }

    private void backtrack(int[] candidates, int target,int index, Set<List<Integer>> res, List<Integer> path) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(target-candidates[i]<0) break;
            path.add(candidates[i]);
            //隐藏了回溯的过程，target不变
            backtrack(candidates,target-candidates[i],i+1,res,path);
            path.remove(path.size()-1);
        }
    }


    //本题的关键在于每个数字只能使用一次，因此可以用一个used数组来保存当前数字是否已经使用过
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2ByRecord(int[] candidates, int target) {
        used=new boolean[candidates.length];
        Arrays.fill(used,false);
        Arrays.sort(candidates);
        backTracking(candidates,target,0);
        return res;
    }
    private void backTracking(int[] candidates,int target,int startIndex){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            if(target-candidates[i]<0) break;
            if(i>0&&!used[i-1]&&candidates[i]==candidates[i-1]){
                continue;
            }
            used[i]=true;
            path.add(candidates[i]);
            backTracking(candidates,target-candidates[i],i+1);
            //不要忘了回溯used
            used[i]=false;
            path.remove(path.size()-1);
        }
    }


}
