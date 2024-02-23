package 代码随想录二刷.二叉树;
//二叉树最大深度
public class _104_maxAndminDepth {
     public int maxDepth(TreeNode root) {
         if(root==null) return 0;
         int leftDepth=maxDepth(root.left);
         int rightDepth=maxDepth(root.right);
         return Math.max(leftDepth,rightDepth)+1;
     }
     //注意最小深度是到叶子节点的深度，如果某子树没有叶子节点，那么最小深度应该是右子树最小深度+1
     public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null||root.left==null) return 1+Math.max(minDepth(root.right),minDepth(root.left));
        return 1+Math.min(minDepth(root.right),minDepth(root.left));
    }
}
