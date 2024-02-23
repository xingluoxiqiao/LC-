package 代码随想录二刷.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//层序遍历
public class _102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=(TreeNode) deque.poll();
                level.add(node.val);
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
