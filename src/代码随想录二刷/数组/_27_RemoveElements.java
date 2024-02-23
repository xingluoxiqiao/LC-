package 代码随想录二刷.数组;

//移除元素
public class _27_RemoveElements {
    public int removeElement(int[] nums, int val){
        int n=nums.length,left=0;
        for(int right=0;right<n;right++){
            if(nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }

}
