package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 */
public class Solution_230 {
    //中序遍历，找到第k个元素
    List<Integer> res=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traversal(root,res);
        return res.get(k-1);
    }
    public void traversal(TreeNode root,List<Integer> res){
        if(root==null) return;
        traversal(root.left,res);
        res.add(root.val);
        traversal(root.right,res);
    }
}
