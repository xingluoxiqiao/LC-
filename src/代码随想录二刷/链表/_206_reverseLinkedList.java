package 代码随想录二刷.链表;

import java.awt.*;

//反转链表
public class _206_reverseLinkedList {
    public ListNode reverseList(ListNode head){
        ListNode temp;
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
