package 面经练习;
//回文链表
public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newHead=reverseList(slow.next);
        boolean res=true;
        while(res&&newHead!=null){
            if(head.val!= newHead.val){
                res=false;
            }
            head=head.next;
            newHead=newHead.next;
        }
        slow.next=reverseList(slow.next);
        return res;
    }
    private ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode temp;
        while(cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
