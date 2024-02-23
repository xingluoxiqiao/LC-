package hot100;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Solution_24 {
    //递归法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存头节点的后继
        ListNode newHead = head.next;
        //头两个节点处理完了，递归处理后面的节点
        head.next = swapPairs(newHead.next);
        //原先 头节点的后继 的现在的后继是头节点
        newHead.next = head;
        return newHead;
    }
    //迭代法
    public ListNode swapPairs2(ListNode head){
        //虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }


}
