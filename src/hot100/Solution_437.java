package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */



public class Solution_437 {
    //组合问题，用回溯法
    //本身也是递归，使用先序遍历，每个节点作为起点满足条件的结果等于自己+左子树+右子树
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }
    //用于递归查询子树中有多少符合条件的结果
    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        //回溯隐藏在参数中
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }




    //前缀和法优化，不用遍历所有路径
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        //将前缀和为0的路径设置为1，这样就可以避免漏掉根节点值等于target这个解
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }
    //找以root为根节点的子树中，前缀和为curr时，有多少个路径满足条件
    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.val;
        //保存当前满足路径的结果总数
        ret = prefix.getOrDefault(curr - targetSum, 0);
        //经过当前节点时保存前缀和
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        //代码随想录.二叉树.回溯
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }


}
