package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 */
public class Solution_160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //分别遍历两个链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //如果两个链表在某处相交，从它们的交点开始应该都是一样长的了
    //所以让两个指针在遍历完一遍链表之后，再交替走一段，它们会同时指向相交的节点
    //如果不相交的话，两个指针分别走完两个链表的长度后同时指向null
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
}
