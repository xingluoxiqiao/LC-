package 代码随想录二刷.回溯算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//全排列
public class _46_permute {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        backTracking(nums);
        return res;
    }
    private void backTracking(int[] nums){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            path.add(nums[i]);
            backTracking(nums);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }

}
