package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 */
public class Solution_560 {
    //暴力解法，枚举所有情况
    public int subarraySum(int[] nums, int k) {
        int res =0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i+1;j<=nums.length;j++){
                sum+=nums[j-1];
                if(sum==k){
                    res++;
                }
            }
        }
        return res;
    }
    //对上述暴力解法进行剪枝，使用前缀和，那么[j..i]这个子数组和为 k 这个条件我们可以转化为 pre[j−1]==pre[i]−k
    //其中pre[i]表示前i个元素的和，当我们遍历到i时，pre[i]-k的值是确定的，这表明pre[j−1]的值也是确定的，
    //要求的个数其实就是说前i个数中前缀和等于pre[j−1]的个数，而每经过一个数，都可以将这个数的前缀和存在map中
    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //初始化，避免数组中有k
        map.put(0,1);
        //记录前缀和
        int sum=0;
        int res=0;
        //每次循环要做的事，求当前前缀和，求pre[i]-k的个数，将当前前缀和存入map中
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            //将当前数的前缀和存入map中
            map.put(sum,map.getOrDefault(sum,0)+1);
            if(map.containsKey(sum-k)){
                 res += map.get(sum - k);
            }
        }
        return res;

    }
}
