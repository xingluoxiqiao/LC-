package 代码随想录二刷.贪心算法;

import java.util.Arrays;

//k次取相反数后的最大数组和
public class _1005_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
            sum+=nums[i];
        }
        //取绝对值最小的数连续反转
        if(k%2==1){
            Arrays.sort(nums);
            sum-=(2*nums[0]);
        }
        return sum;
    }
}
