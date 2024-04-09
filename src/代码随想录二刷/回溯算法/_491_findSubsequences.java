package 代码随想录二刷.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//非递减子序列
public class _491_findSubsequences {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;
    }
    private void backTracking(int[] nums,int index){
        if(path.size()>=2){
            res.add(new ArrayList<>(path));
            path.clear();
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(hashSet.contains(nums[i])||(!path.isEmpty()&&path.get(path.size()-1)>nums[i])) continue;
            hashSet.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
