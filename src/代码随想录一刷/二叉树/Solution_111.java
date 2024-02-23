package 代码随想录一刷.二叉树;

/**
 * 二叉树最小深度
 * 易错点是根节点如果没有左子树或右子树，最小深度不是1，而是1+子树最小深度
 */
public class Solution_111 {
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null||root.left==null) return 1+Math.max(minDepth(root.right),minDepth(root.left));
        return 1+Math.min(minDepth(root.right),minDepth(root.left));
    }
}
