package HOT_150;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
//如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//请必须使用时间复杂度为 O(log n) 的算法


//二分查找，注意边界
public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1,res=nums.length;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(target<=nums[mid]){
                res=mid;
                high=mid-1;
            }else {
                low = mid + 1;
            }

        }
        return res;
    }
}
