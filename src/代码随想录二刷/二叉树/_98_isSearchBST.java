package 代码随想录二刷.二叉树;
//验证二叉搜索树
public class _98_isSearchBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    //递归判断当前root节点为根节点的树是否为二叉搜索树
    //min和max用于限定当前节点的值，即左子树不能大于当前节点，右子树不能小于当前节点
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        //左子树或右子树的每个节点值都要在范围内
        //首先当前节点要在范围内，通过当前节点的值限定其子节点的范围
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
