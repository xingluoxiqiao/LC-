package 代码随想录二刷.链表;

import java.util.LinkedList;

//设计链表
public class _707_DisignLinkedlist {
    class ListNode{
        int val;
        ListNode next;
        public  ListNode(){}
        public ListNode(int val){
            this.val=val;
        }
    }

    class MyLinkedList {
        private int size;
        private ListNode head;
        public MyLinkedList(){
            size=0;
            head=new ListNode(0);
        }

        public int get(int index) {
            if(index>=size||index<0) return -1;
            ListNode cur=head;
            for(int i=0;i<=index;i++){
                cur=cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if(index>size) return;
            size++;
            if(index<0){
                ListNode listNode = new ListNode(val);
                listNode.next=head;
            }
            ListNode cur=head;
            ListNode node=new ListNode(val);
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            node.next=cur.next;
            cur.next=node;
        }

        public void deleteAtIndex(int index) {
            if(index>=size||index<0){
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }
}
