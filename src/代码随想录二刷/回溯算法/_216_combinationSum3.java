package 代码随想录二刷.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//组合总和3
public class _216_combinationSum3 {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k,n,1);
        return res;
    }
    private void backTracking(int k,int n,int startIndex){
        if(n==0&&path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<=9;i++){
            path.add(i);
            backTracking(k,n-i,i+1);
            path.removeLast();
        }
    }
}
