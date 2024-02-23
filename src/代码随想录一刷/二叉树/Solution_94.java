package 代码随想录一刷.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class Solution_94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travelsal(root, res);
        return res;
    }

    public static void travelsal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        travelsal(root.left, res);
        res.add(root.val);
        travelsal(root.right, res);
        ;
    }
    //迭代法
    public static List<Integer> inorderTraversalwithdiedai(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur.left);
                cur = cur.left;
            }else{
                cur=stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

}