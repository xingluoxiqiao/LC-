package 代码随想录二刷.哈希表;

import java.util.*;

//三数之和
public class _15_threeSum {
    public List<List<Integer>> threeSum(int[] nums){
        if(nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int left,right;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return res;
            if(i>0&&nums[i]==nums[i-1]) continue;
            left=i+1;
            right=nums.length-1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left+1]==nums[left]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
