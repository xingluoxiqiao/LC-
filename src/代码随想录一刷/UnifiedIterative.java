package 代码随想录一刷;

import 代码随想录一刷.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树统一迭代法
 * 在需要处理的节点（中节点）后面加一个null标记
 * 统一迭代法，统一处理前序、中序、后序遍历
 */
public class UnifiedIterative {
    //前序
    public static List<Integer> inOrderUnifiedIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur=stack.peek();
            if (cur != null) {
                stack.pop();
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
                stack.push(cur);
                stack.push(null);
            } else {
                stack.pop();
                TreeNode node = stack.peek();
                stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
    //中序
    public static List<Integer> midOrderUnifiedIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
    //后序
    public static List<Integer> postOrderUnifiedIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                stack.pop();
                stack.push(cur);
                stack.push(null);
                if (cur.right != null) stack.push(cur.right);
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
}
