package 代码随想录二刷.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

//找树左下角的值
public class _513_findBottomLeftValue {
    //层序遍历输出最后一层的第一个值
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.offer(root);
        int res=0;
        while(!deque.isEmpty()){
            int size=deque.size();
            for(int i=0;i<size;i++){
                TreeNode cur=deque.peek();
                deque.poll();
                if(i==0) res=cur.val;
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
            }
        }
        return  res;
    }

    //递归
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue2(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }
    private void findLeftValue(TreeNode root,int deep){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            if(deep>Deep){
                value=root.val;
                Deep=deep;
            }
        }
        if(root.left!=null) findLeftValue(root.left,deep+1);
        if(root.right!=null) findLeftValue(root.right,deep+1);

    }
}
