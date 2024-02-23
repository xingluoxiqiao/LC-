package 代码随想录一刷.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * 二叉树后序遍历
 */
public class Solution_145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travelsal(root, res);
        return res;
    }

    public static void travelsal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        travelsal(root.left, res);
        travelsal(root.right, res);
        res.add(root.val);
    }

    //迭代法
    public static List<Integer> postorderTraversalwithdiedai(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
