package 代码随想录二刷.链表;
//删除链表倒数第n个节点
public class _19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy=new ListNode(-1,head);
        ListNode slow=dummy,fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
