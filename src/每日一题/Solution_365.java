package 每日一题;

import java.util.*;

/**
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * 你可以：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */

//设一个容量为x，另一个容量为y，每次水的总变化量只可能是x,y,-x,-y中的一种
//因为如果一个杯子半满而把它清空或加满是没有意义的（向另一个杯子里倒总量不变）
    //因此需要找到整数a,b,使ax+by=targetCapacity
    //ax+by=z 有解当且仅当 z 是 x,y 的最大公约数的倍数
public class Solution_365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }




    //深搜，每次有六种可能，全部遍历一遍
    //注意保存结果，避免无限循环
    public boolean canMeasureWater2(int x, int y, int z) {
        Deque<int[]> stack =new LinkedList<int []>();
        stack.push(new int[]{0,0});
        Set<Long> seen = new HashSet<Long>();
        while(!stack.isEmpty()){
            if(seen.contains(hash(stack.peek()))){
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remain_x=state[0],remain_y=state[1];
            if(remain_x==z||remain_y==z||remain_x+remain_y==z){
                return true;
            }
            stack.push(new int[]{x,remain_y});
            stack.push(new int[]{remain_x,y});
            stack.push(new int[]{0,remain_y});
            stack.push(new int[]{remain_x,0});
            stack.push(new int[]{remain_x-Math.min(remain_x,y-remain_y),remain_y+Math.min(remain_x,y-remain_y)});
            stack.push(new int[]{remain_x+Math.min(remain_y,x-remain_x),remain_y-Math.min(remain_y,x-remain_x)});
        }
        return false;
    }
    public long hash(int[] state){
        return (long)state[0]*1000001+state[1];
    }
}
