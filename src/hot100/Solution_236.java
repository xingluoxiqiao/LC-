package hot100;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //要寻找的两个节点其中之一是当前节点，直接返回当前节点
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树上没有这两个节点，那它们全在右子树上，返回右子树上的最近公共祖先
        if(left == null) return right;
        if(right == null) return left;

        //如果函数走到这里
        //说明两个节点都在当前节点的子树上且分列两边，则当前节点就是最近公共祖先
        return root;
    }
}
