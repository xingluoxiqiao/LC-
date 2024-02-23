package 代码随想录二刷.栈与队列;

import java.util.*;

//前k个高频元素
public class _347_topKFrequent___ {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return map.get(a)-map.get(b);
            }
        });
        for(Integer key:map.keySet()){
            if(queue.size()<k){
                queue.add(key);
            }else if(map.get(key)>map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
