package 代码随想录二刷.二叉树;

import java.util.ArrayList;
import java.util.List;

//二叉树遍历递归法
public class treeRecursiveTraversal {
    public List<Integer> Traversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorderTravsal(root,res);
//        inorderTravsal(root,res);
//        postorderTravsal(root,res);
        return res;
    }
    //前序
    public void preorderTravsal(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorderTravsal(root.left,res);
        preorderTravsal(root.right,res);
    }
    //后序
    public void postorderTravsal(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        postorderTravsal(root.left,res);
        postorderTravsal(root.right,res);
    }
    public void inorderTravsal(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        inorderTravsal(root.left,res);
        inorderTravsal(root.right,res);
    }
}
