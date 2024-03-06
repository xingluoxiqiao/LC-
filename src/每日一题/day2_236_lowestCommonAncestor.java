package 每日一题;
//二叉搜索树的最近公共祖先
public class day2_236_lowestCommonAncestor {
    //二叉搜索树特点：中序遍历是有序的(左侧所有节点小于当前节点，右侧所有节点大于当前节点)
    //若pq分散在当前节点左右子树上，则返回当前节点
    //若pq在当前节点同一侧，遍历这一侧
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if(root.val== p.val) return p;
        if(root.val== q.val) return q;
        if(p.val<root.val&&q.val>root.val) return root;
        else if(p.val>root.val&&q.val<root.val) return root;
        else if(p.val>root.val&&q.val>root.val) res=lowestCommonAncestor(root.right,p,q);
        else if(p.val<root.val&&q.val<root.val) res=lowestCommonAncestor(root.left,p,q);
        return res;
    }
}
