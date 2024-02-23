package hot100;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution_25 {
    //关键在于将每组都作为独立的小段，添加虚拟头节点和虚拟尾节点，方便操作
    //注意变量的取用，好好想清楚到底要用到哪些变量
    public ListNode reverseKGroup(ListNode head, int k){
        //用于返回最终结果
        ListNode dummy=null;
        //用于保存每一段的虚拟头和尾
        ListNode pre=dummy;
        ListNode end=dummy;
        while(end!=null){
            //每层循环完成后，end指向第k个节点
            for(int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end==null) break;
            ListNode start=pre.next;
            ListNode next=end.next;
            end.next=null;
            pre.next=reverseList(start);
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
