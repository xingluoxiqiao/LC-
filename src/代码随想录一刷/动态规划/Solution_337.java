package 代码随想录一刷.动态规划;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */

//采用后序遍历递归每一个节点，返回两个值
public class Solution_337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        //不偷当前节点，可以偷自己的左右孩子之和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点，不能偷左右孩子
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
