package 代码随想录一刷.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 */
public class Solution_144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travelsal(root,res);
        return res;
    }
    public static void travelsal(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        travelsal(root.left,res);
        travelsal(root.right,res);
    }

    //迭代法
    public static List<Integer> inorderTraversalwithdiedai(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return res;
    }

}
