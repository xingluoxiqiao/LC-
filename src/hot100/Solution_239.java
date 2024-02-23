package hot100;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */

//维护一个优先级队列，每次滑动窗口时更新
public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //这个队列的性质：存放的是数组的下标，从小到大；并且数组下标对应的元素值是从大到小的
        //如果存在i<j，并且nums[i]<nums[j]，那么i一定在队列中，j一定不在队列中;那i就应该被移除，因为只要j在，它永远不可能是最大值
        //不应该关注队列的大小，而应该关注队列的头节点是否在窗口内
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.如果当前加入的元素比队列末尾的元素大，则队列末尾的元素一定不会是最大值，可以弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
