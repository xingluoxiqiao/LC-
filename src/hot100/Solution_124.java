package hot100;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution_124 {
    //对一个节点来说（也就是路径必须要包含这个节点）
    //最大路径和有三种情况：
    //1. 左子树最大路径和+右子树最大路径和+root.val
    //2. 左子树最大路径和+root.val
    //3. 右子树最大路径和+root.val
    //取三种情况的最大值
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    public  int maxGain(TreeNode node){
        if(node == null) return 0;
        //递归计算左右子节点的最大贡献值,如果小于0则贡献值为0（相当于舍弃）
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);
        //保存当前可能的最大路径和（上述三种情况三合一了）
        maxSum = Math.max(maxSum,leftGain+rightGain+node.val);
        //对当前节点来说，如果它想要继续和自己的父节点组成路径，它只能选择自己的左右子树的其中之一
        return node.val+Math.max(leftGain,rightGain);
    }

}
