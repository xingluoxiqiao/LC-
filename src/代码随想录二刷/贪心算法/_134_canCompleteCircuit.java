package 代码随想录二刷.贪心算法;
//加油站
public class _134_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest=0;
        int start=0;
        int total=0;
        for(int i=0;i<gas.length;i++){
            //从0开始行驶到i总共剩的油
            rest+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            //只要剩的油小于0了，表明无论从当前节点之前的哪个节点出发到这里都会断油，必须从头开始
            //这是由start的更新保证的，一旦小于0就会更新start，不存在某个区间（当前节点之前的某个节点到当前节点）会大于0
            if(rest<0) {
                start=i+1;
                rest=0;
            }
        }
        return total<0?-1:start;
    }
}
