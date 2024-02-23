package 代码随想录二刷.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//组合
public class _77_combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<Integer> path=new LinkedList<>();
        backTracking(res,path,1,n,k);
        return res;
    }
    private void backTracking(List<List<Integer>> res, LinkedList<Integer> path, int startIndex, int n, int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<= n - (k - path.size()) + 1;i++){
            path.add(i);
            backTracking(res,path,i+1,n,k);
            path.removeLast();
        }
    }



}

