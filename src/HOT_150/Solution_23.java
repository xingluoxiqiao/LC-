package HOT_150;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution_23 {
    //分治法
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid=(l+r)>>1;
        return mergeKLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeKLists(ListNode a,ListNode b){
        if(a==null||b==null){
            return a!=null?a:b;
        }
        ListNode head=new ListNode(0);
        ListNode tail=head,aPtr=a,bPtr=b;
        while(aPtr!=null&&bPtr!=null){
            if(aPtr.val<bPtr.val){
                tail.next=aPtr;
                aPtr=aPtr.next;
            }else{
                tail.next=bPtr;
                bPtr=bPtr.next;
            }
            tail=tail.next;
        }
        tail.next=(aPtr!=null?aPtr:bPtr);
        return head.next;
    }


    //优先队列
    PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {return  o1.val-o2.val;}));
    public ListNode mergeKLists2(ListNode[] lists) {
        for(ListNode node:lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode s = pq.poll();
            cur.next = s;
            cur=cur.next;
            s = s.next;
            if(s!=null){
                pq.offer(s);
            }
        }
        return dummy.next;
    }
}
