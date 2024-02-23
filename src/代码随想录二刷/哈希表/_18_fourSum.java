package 代码随想录二刷.哈希表;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.*;

//四数之和
public class _18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target){
        if(nums.length<4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int left,right;
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0&&nums[j]>target){
                return res;
            }
            if(j>0&&nums[j]==nums[j-1]) continue;
            for(int i=j+1;i<nums.length;i++){
                if(i>j+1&&nums[i-1]==nums[i]) continue;
                left=i+1;
                right=nums.length-1;
                while(right>left){
                    int sum=nums[j]+nums[i]+nums[left]+nums[right];
                    if(sum<target){
                        left++;
                    }else if(sum>target){
                        right--;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while ((left<right&&nums[right]==nums[right-1])) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
