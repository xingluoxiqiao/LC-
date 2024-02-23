package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Solution_94 {
    //统一迭代法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                if (cur.right != null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) stack.push(cur.left);
            } else {
                stack.pop();
                TreeNode node = stack.peek();
                stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    //递归法
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }
}
