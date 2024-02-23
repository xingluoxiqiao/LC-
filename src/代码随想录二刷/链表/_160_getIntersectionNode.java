package 代码随想录二刷.链表;
//链表相交
public class _160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB==null||headA==null) return null;
        ListNode node1=headA,node2=headB;
        while(node1!=node2){
            node1= node1==null?headB:node1.next;
            node2= node2==null?headA:node2.next;
        }
        return node1;
    }
}
