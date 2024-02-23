package 代码随想录二刷.链表;

import java.awt.*;

//移除链表元素
public class _203_removeElementsLinkedlist {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0, head);
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }
            else {
                pre=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}
