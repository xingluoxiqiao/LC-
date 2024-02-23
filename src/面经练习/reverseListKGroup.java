package 面经练习;
//k个一组反转链表
public class reverseListKGroup {
    class ListNode{
        private int val;
        private ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public ListNode reverseKGroup(ListNode head,int k) {
        //虚拟头节点，用于返回结果，不能改变
        ListNode dummy = new ListNode(-1,head);
        //用于保存即将开始反转的头节点的前置节点
        ListNode pre = dummy;
        //用于遍历获取第k个节点
        ListNode cur = dummy;
        while (cur != null) {
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
            //最后剩余的节点保持原有顺序
            if (cur == null) break;
            //当前反转的头节点
            ListNode start = pre.next;
            //保存下一个需要反转的头节点
            ListNode next = cur.next;
            cur.next=null;
            //反转后的头节点链接到虚拟节点
            pre.next = reverseList(start);
            //当前反转的头节点反转后链接到下一个需要反转的节点
            start.next = next;
            //更新前置节点
            pre = start;
            //更新当前节点
            cur = pre;
        }
        return dummy.next;
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
