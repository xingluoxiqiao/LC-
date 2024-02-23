package 代码随想录二刷.栈与队列;

import java.util.ArrayDeque;

//滑动矿口最大值
public class _239_maxSlidingWindow {
    //自己维护一个队列，满足
    //1.队列中存放数组下标，从小到大
    //2.头节点小于i-k+1时需要移除
    //3.小于队列尾的值不需要放进队列中
    //采用先放入再删除的方法，每次放入前统一处理上次遗留的问题（是否要删除头节点，是否要删除尾节点）
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque=new ArrayDeque();
        int[] res=new int[nums.length-k+1];
        int left=0;
        for(int i=0;i<nums.length;i++){
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i>=k-1){
                res[left++]=nums[deque.peek()];
            }
        }
        return res;
    }
}
