package 代码随想录二刷.二叉树;

import javax.xml.parsers.SAXParser;
import java.util.*;

public class treeIterativeTraversal {
    public List<Integer> preTraversal(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.peek();
            stack.pop();
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return res;
    }

    public List<Integer> inTraversal(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        stack.push(cur);
        while(!stack.isEmpty()&&cur!=null){
            if(cur.left!=null){
                stack.push(cur.left);
                cur=cur.left;
            }
            else{
                cur = stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
    public List<Integer> postTraversal(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.peek();
            stack.pop();
            res.add(cur.val);
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> preorderTraversalUnion(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }


}
