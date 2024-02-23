package 代码随想录二刷.哈希表;

import java.util.HashMap;
import java.util.Map;

//四数相加II
public class _454_fourSumCount {
    public int fourSumCountII(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int i:nums1){
            for (int j:nums2){
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        for(int i:nums3){
            for (int j:nums4){
                res+=map.getOrDefault(0-i-j,0);
            }
        }
        return res;
    }
}
