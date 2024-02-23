package hot100;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */

//O (nlogn)解法，自底向上归并
public class Solution_148 {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        //计算链表长度
        int length=0;
        ListNode node=head;
        while(node!=null){
            length++;
            node=node.next;
        }
        ListNode dummyHead=new ListNode(0,head);
        //从长度为1开始归并，直到整个链表长度
        for(int subLength=1;subLength<length;subLength<<=1){
            ListNode prev=dummyHead,cur=dummyHead.next;
            while(cur!=null){
                ListNode head1=cur;
                for(int i=1;i<subLength&&cur.next!=null;i++){
                    cur=cur.next;
                }
                ListNode head2=cur.next;
                //切割分成两个链表
                cur.next=null;
                cur=head2;
                for(int i=1;i<subLength&&cur!=null&&cur.next!=null;i++){
                    cur=cur.next;
                }
                ListNode next=null;
                if(cur!=null){
                    next=cur.next;
                    cur.next=null;
                }
                ListNode merged=merge(head1,head2);
                prev.next=merged;
                while(prev.next!=null){
                    prev=prev.next;
                }
                cur=next;
            }
        }
        return dummyHead.next;
    }
    //合并两个有序链表
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead,temp1=head1,temp2=head2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        } else if(temp2!=null){
            temp.next=temp2;
        }
        return dummyHead.next;
    }
}
