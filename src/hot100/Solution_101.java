package hot100;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    private boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }
}
