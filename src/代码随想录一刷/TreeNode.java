package 代码随想录一刷;

/**
 * 二叉树前序遍历
 * <p>
 * 给定一个二叉树，返回它的 前序 遍历。
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
