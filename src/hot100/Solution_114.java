package hot100;

import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，
 * 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Solution_114 {
    //先序迭代遍历
    //左孩子接到左孩子的最右下节点
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
    //递归，需要注意的是，本题中如果直接使用先序会使右子树的位置丢失（因为左子树被换到了右子树的位置）
    //因此，需要使用一个全局变量来保存右子树的位置，并且使用后序最后来处理中节点（的右子树）
    private TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    //利用栈暂存右孩子
    public void flatten3(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            if(pre!=null){
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            }
            pre = temp;
        }
    }
}
