package 代码随想录二刷.二叉树;
//反转二叉树
public class _226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        travsal(root);
        return root;
    }

    private void travsal(TreeNode root){
        TreeNode temp;
        if(root==null) return ;
        if(root.left==null&&root.right==null) return;
        temp=root.right;
        root.right=root.left;
        root.left=temp;
        travsal(root.left);
        travsal(root.right);
    }

}
