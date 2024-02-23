package hot100;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder  先序遍历数组
     * @param preStart  子树先序遍历数组起始索引
     * @param preEnd    子树先序遍历数组结束索引
     * @param inorder   中序遍历数组
     * @param inStart   子树中序遍历数组起始索引
     * @param inEnd     子树中序遍历数组结束索引
     * @return
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //通过先序数组值构建当前节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inStart;
        //在中序数组中找到当前节点
        //确定左右子树中序遍历起始和结束索引
        //以及左子树节点个数用于在先序数组中确定子树先序遍历起始和结束索引
        while (inorder[index] != root.val) {
            index++;
        }
        //递归构建左子树
        root.left = build(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        //递归构建右子树
        root.right = build(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}

