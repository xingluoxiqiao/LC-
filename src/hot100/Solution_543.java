package hot100;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */


//每条路径的长度都可以转化为 某个节点为根节点的子树 的左右子树深度之和
public class Solution_543 {
    //用来记录最大结果
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {

        ans = 0;
        depth(root);
        return ans ;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R ); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R)+1 ; // 返回该节点为根的子树的深度
    }
}
