package another;

import java.util.HashMap;
import java.util.Scanner;
//输入：DBACEGF ABCDEFG（前序遍历和中序遍历）
//     BCAD CBAD
//输出：ACBFGED（后序遍历）
//     CDAB
public class BuildBinaryTree {
    private static HashMap<Character,Integer> hashmap;
    private static int nodeIdx;
    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){};
        public TreeNode(char val){
            this.val = val;
        }
    }

    // 需要哈希表快速定位 中序序列中结点->下标的映射
    private static TreeNode buildTree(char[] preOrder,char[] inOrder){
        int n =preOrder.length;
        return build(preOrder,inOrder,0,n-1); // 最后两个参数控制inOrder的范围
    }

    private static TreeNode build(char[] preOrder,char[] inOrder,int l,int r){
        int n = preOrder.length;
        if(nodeIdx>=n || l>r) return null;
        char rootVal = preOrder[nodeIdx];
        TreeNode root = new TreeNode(rootVal);
        ++nodeIdx;
        int mid = hashmap.get(rootVal);
        root.left = build(preOrder,inOrder,l,mid-1);
        root.right = build(preOrder,inOrder,mid+1,r);
        return root;
    }

    private static void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        dfs(root.right);
        System.out.print(root.val);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String[] input = in.nextLine().split(" ");
            char[] preOrder = input[0].toCharArray();
            char[] inOrder = input[1].toCharArray();
            hashmap = new HashMap<Character,Integer>();
            nodeIdx = 0;
            for(int i=0;i<inOrder.length;i++){
                hashmap.put(inOrder[i],i);
            }
            TreeNode root = buildTree(preOrder,inOrder);
            dfs(root);
            System.out.println("");
        }
    }
}
