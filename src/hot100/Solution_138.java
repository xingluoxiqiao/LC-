package hot100;

import java.util.HashMap;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 */
public class Solution_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //不能一边遍历一边复制，如果前面的rondom指向了后面的节点，是不能直接建立联系的
    //通过两次遍历，第一次先创建好所有的节点，并将新节点和对应的旧节点通过hashmap绑定
    //第二次再遍历旧链表，根据旧链表的节点关系创建新链表的节点关系
        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }
            Node cur = head;
            HashMap<Node,Node> map = new HashMap<>();
            while(cur!=null){
                map.put(cur,new Node(cur.val));
                cur = cur.next;
            }
            cur=head;
            while(cur!=null){
                map.get(cur).next=map.get(cur.next);
                map.get(cur).random=map.get(cur.random);
                cur=cur.next;
            }
            return map.get(head);
        }
}
