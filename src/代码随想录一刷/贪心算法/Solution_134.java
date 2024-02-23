package 代码随想录一刷.贪心算法;

/**
 *  134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 *
 * 思路：先获取“净增油量”数组，在此基础上遍历，求净增油量数组前n项和，为负数直接从下一个开始遍历
 */
public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum=0;
        int totalSum=0;
        int result=0;
        for (int i = 0; i < gas.length; i++) {
            curSum+= gas[i]-cost[i];
            totalSum+= gas[i]-cost[i];
            if(curSum<0){
                result = (i + 1) % gas.length ;
                curSum=0;
            }
        }
        if(totalSum<0) return -1;
        return result;
    }
}
