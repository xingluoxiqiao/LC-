package 代码随想录二刷.二叉树;
//对称二叉树
//需要注意比较的是整棵树的内外侧，而不是某一节点的左右子节点
public class _101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }
    private boolean compare(TreeNode left,TreeNode right){

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
