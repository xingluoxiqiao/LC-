package 每日一题;
//二叉树中的第k大层和


import java.util.*;

//层序遍历+排序
public class day2_2583_kthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        List<Long> list=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                sum+=cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            list.add(sum);
        }
        list.sort(Collections.reverseOrder());
        long kthLargest = -1;
        if (k > 0 && k <= list.size()) {
            kthLargest = list.get(k - 1);
        }
        return kthLargest;
    }
}
