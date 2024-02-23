package 代码随想录二刷.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//组合总和
public class _39_combinationSum {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            path.add(candidates[i]);
            backTracking(candidates,target-candidates[i],i);
            path.removeLast();
        }
    }

}
