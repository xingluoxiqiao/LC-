package HOT_150;

/**
 *给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Solution_61 {
    //先将链表闭合为环，然后找到新的头节点，断开环，返回新的头节点
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode cur=head;
        int n=1;
        while(cur.next!=null){
            cur=cur.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        cur.next = head;
        while (add-- > 0) {
            cur = cur.next;
        }
        ListNode ret = cur.next;
        cur.next = null;
        return ret;
    }
}
