package 代码随想录二刷.哈希表;

import java.util.HashSet;
import java.util.Set;

//两个数组的交集
public class _349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        if(m==0||n==0||nums1==null||nums2==null){
            return new int[0];
        }
        Set<Integer> set1=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            if(set1.contains(nums2[j])){
                res.add(nums2[j]);
            }
        }
        //return res.stream().mapToInt(x->x).toArray();
        int[] resActual =new int[res.size()];
        int count=0;
        for(int i:res){
            resActual[count++]=i;
        }
        return resActual;
    }
}
