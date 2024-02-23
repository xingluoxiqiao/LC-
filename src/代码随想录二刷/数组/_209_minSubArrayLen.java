package 代码随想录二刷.数组;
//长度最小子数组
public class _209_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums){
        int left=0,right=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        while(right<nums.length){
            sum+=nums[right++];
            while(sum>=target){
                sum-=nums[left++];
                if(sum<target){
                    res=Math.min(res,right-left+1);
                }
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

}
