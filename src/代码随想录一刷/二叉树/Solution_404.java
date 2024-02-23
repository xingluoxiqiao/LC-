package 代码随想录一刷.二叉树;

/**
 *
 * 左叶子之和
 */
public class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int left = sumOfLeftLeaves(root.left);
        int right =sumOfLeftLeaves(root.right);
        int mid=0;
        if(root.left != null && root.left.left == null&&root.left.right==null) {
            mid=root.left.val;
        }
        return  mid+left+right;
    }
}
