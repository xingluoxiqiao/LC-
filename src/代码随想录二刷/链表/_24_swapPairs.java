package 代码随想录二刷.链表;
//两两交换链表中的节点
public class _24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        ListNode node1,node2;
        while(temp.next!=null&&temp.next.next!=null){
            node1=temp.next;
            node2=temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummy.next;
    }
}
