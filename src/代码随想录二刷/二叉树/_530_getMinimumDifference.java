package 代码随想录二刷.二叉树;

import java.util.Map;

//二叉搜索树的最小绝对差
public class _530_getMinimumDifference {
    //遇到在二叉搜索树上求什么最值，求差值之类的，都要思考一下二叉搜索树可是有序的，要利用好这一特点。
    //但是一定要注意二叉搜索树只有中序遍历是有序的
    TreeNode pre=null;
    int res=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        travsal(root);
        return res;
    }
    public void travsal(TreeNode root){
        if(root==null) return;
        travsal(root.left);
        if(pre!=null){
            res= Math.min(res,root.val-pre.val);
        }
        pre=root;
        travsal(root.right);
    }
}
