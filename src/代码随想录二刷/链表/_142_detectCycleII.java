package 代码随想录二刷.链表;
//环形链表II
public class _142_detectCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(true){
            if(fast==null||fast.next==null) return  null;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
