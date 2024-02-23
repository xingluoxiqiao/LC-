package 代码随想录二刷.二叉树;

import java.util.HashMap;
import java.util.Map;

//从中序和后序遍历序列构建二叉树

//要点：坚持区间不变量，左闭右开
//
public class _106_buildTreeFromInAndPost {
    //中序：左中右，后序：左右中
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeIndex(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode buildTreeIndex(int[] inorder,int startIn,int endIn,int[] postorder,int startPost,int endPost){
        //如果区间边界不满足左闭右开，要退出（生成空节点）
        if(startPost>=endPost||startIn>=endIn) return null;
        //后序的最后一个节点是当前节点，获取它在中序中的位置可以确定其左右子树的区间
        int rootIndex = map.get(postorder[endPost-1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        //获取左子树区间大小
        int leftCount=rootIndex-startIn;
        root.left=buildTreeIndex(inorder,startIn,rootIndex,postorder,startPost,startPost+leftCount);
        root.right=buildTreeIndex(inorder,rootIndex+1,endIn,postorder,startPost+leftCount,endPost-1);
        return root;
    }

}

