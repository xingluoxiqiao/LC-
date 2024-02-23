package 代码随想录一刷.贪心算法;

/**
 * 968.监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * 思路：
 * 贪心：叶节点不放摄像头，给叶子节点的父节点放摄像头，并且每两个摄像头之间相隔两层
 * 每个节点的状态：有覆盖1，无覆盖2，有摄像头3（无摄像头必然是有覆盖和无覆盖之一）
 * 递归函数遇到空节点返回，应该给空节点赋状态，分析后赋有覆盖1
 * 父节点的状态由子节点决定，
 * 1.均有覆盖，父节点为无覆盖
 * 2.任一子节点无覆盖，父节点为有摄像头
 * 3.任一子节点有摄像头，父节点为有覆盖
 * 4.特殊情况，根节点为无覆盖时，必须分配摄像头
 *二叉树遍历顺序：左右中（后序），因为父节点（当前节点）的状态来自于子节点
 */
public class Solution_968____ {
    int result=0;
    public int travelsal(TreeNode root){
        //出口  空节点返回有覆盖1
        if(root==null) return 1;
        //递归
        int left= travelsal(root.left);
        int right=travelsal(root.right);
        //父节点处理
        if(left==1&&right==1) return 2;
        else if(left==2||right==2) {
            //当前节点是摄像头，计算器加1
            result++;
            return 3;
        }
        else return 1;
     }
    public int minCameraCover(TreeNode root) {
        if(travelsal(root)==2) result++;
        return result;
    }
}
