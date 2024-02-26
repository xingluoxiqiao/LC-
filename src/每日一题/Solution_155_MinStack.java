package 每日一题;

import java.util.LinkedList;
import java.util.Map;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//每个元素入栈时保存它与当前最小值的差值
public class Solution_155_MinStack {
    class MinStack {
        private long minNum;
        private LinkedList<Long> linkedList;
        public MinStack() {
            this.linkedList=new LinkedList<>();
        }

         public void push(int val) {
            if(linkedList.isEmpty()){
                minNum=val;
                linkedList.add(0L);
                return;
            }
            linkedList.push((long) val-minNum);
            //放入后再更新，此时的minNum才是当前栈中所有元素的最小值
            minNum = Math.min((long)val,minNum);
        }

        public void pop() {
            long pop = linkedList.removeFirst();
            // 当弹出元素小于0时，说明弹出元素是当前栈中的最小值，要更新最小值
            if(pop<0){
                // 因为对于当前弹出的元素而言，计算压入栈中的值时，计算的是该元素与【未压入】该元素时栈中元素的最小值的差值，
                // 故弹出该元素后栈中的最小值就是未压入该元素时的最小值即当前元素的值（min）减去两者的差值
                long lastMin = minNum;
                //放入当前元素前最小的值等于当前值加上它们间的差值，由于是负数，这里是减
                minNum = lastMin - pop;
            }
            // 若大于等于0，不会对min有影响
        }

        public int top() {
            long peek = linkedList.peek();
            // 若当前栈顶小于等于0，说明最小值就是栈顶元素
            if(peek<=0) return (int)minNum;
            // 否则就是min+peek
            return (int)(minNum+peek);
        }

        public int getMin() {
            return (int)minNum;
        }
    }
}
