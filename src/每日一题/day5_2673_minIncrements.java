package 每日一题;
//使满二叉树所有路径和相等的最小代价
//思路：
//1.考虑满二叉树中的一对兄弟叶子节点
//2.其余所有节点要么是它们的共同祖先，要么和它们没有关系，因此若它们不相等，必须进行操作
//3.对所有叶子节点进行操作后，每组兄弟叶子节点对应的两条路径已经必然相等
//4.将叶子节点中较大值加给它们的父节点，便可以忽略这对兄弟节点的影响，父节点成为新的叶子节点
//5.因此从下至上一层层累加，直至根节点，即为最终结果
public class day5_2673_minIncrements {
    //整数 n 表示一棵 满二叉树 里面节点的数目,cost[i] 是第 i + 1 个节点的值
     public int minIncrements(int n, int[] cost) {
         int ans=0;
         for(int i=n-2;i>=0;i-=2){
             ans+=Math.abs(cost[i]-cost[i+1]);
             cost[i/2]+=Math.max(cost[i],cost[i+1]);
         }
         return ans;
     }
}
