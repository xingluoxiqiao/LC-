package 代码随想录二刷.二叉树;
//完全二叉树的节点个数
public class _222_countNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int leftDepth=0,rightDepth=0;
        while(left!=null) {
            left=left.left;
            leftDepth++;
        }
        while(right!=null) {
            right=right.right;
            rightDepth++;
        }
        if(leftDepth==rightDepth){
            return (2<<leftDepth)-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }


    // 通用递归解法
    public int countNodes2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
