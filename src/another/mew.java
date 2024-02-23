package another;

import org.w3c.dom.Node;
import 代码随想录二刷.链表.ListNode;

public class mew {
    static class linkNode{
        private int val;
        private linkNode next;
        public linkNode(){}
        public linkNode(int val){
            this.val=val;
        }
        public linkNode(int val,linkNode node){
            this.val=val;
            this.next=node;
        }
    }
    private static linkNode remove(linkNode head,int n){
        int size=0;
        linkNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(n>size) return null;
        linkNode dummy=new linkNode(-1,head);
        linkNode slow=dummy,fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        Integer a =new Integer(-127);
        int b=-127;
        int c=Integer.valueOf(-127);
        System.out.println(a==b);
//        linkNode head= new linkNode(1,new linkNode(2,new linkNode(3,null)));
//        linkNode newHead=remove(head,4);
//        while(newHead.next!=null){
//            System.out.println(newHead.val+" ");
//            newHead=newHead.next;
//        }
    }
}
