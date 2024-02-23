package hot100;

import jdk.jshell.spi.SPIResolutionException;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class Solution_146 {
    class LRUCache {
        class DLinkedNode{
            private int key;
            private int value;
            private DLinkedNode prev;
            private DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int _key,int _value){
                this.key=_key;
                this.value=_value;
            }
        }
        private Map<Integer,DLinkedNode> cache=new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head,tail;
        public LRUCache(int capacity) {
            this.size=0;
            this.capacity=capacity;
            //虚拟头尾节点，方便移动到链表头部操作
            head=new DLinkedNode();
            tail=new DLinkedNode();
            head.next=tail;
            tail.prev=head;
        }

        public int get(int key) {
            DLinkedNode node=cache.get(key);
            if(node==null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode cur=cache.get(key);
            if(cur==null){
                //新增元素时插入链表的头部，并加入缓存
                DLinkedNode node=new DLinkedNode(key,value);
                cache.put(key,node);
                addToHead(node);
                ++size;
                if(size>capacity){
                    DLinkedNode old=removeTail();
                    cache.remove(old.key);
                    --size;
                }
            }else {
                cur.value=value;
                moveToHead(cur);
            }

        }
        private void moveToHead(DLinkedNode node){
            removeNode(node);
            addToHead(node);
        }
        private void addToHead(DLinkedNode node){
            node.prev=head;
            head.next.prev=node;
            node.next=head.next;
            head.next=node;
        }

        private void removeNode(DLinkedNode node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }

        private DLinkedNode removeTail(){
            DLinkedNode node=tail.prev;
            removeNode(node);
            return node;
        }

    }
}
