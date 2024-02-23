package 代码随想录二刷.二叉树;
//根据规则构建二叉树

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class _654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length);
    }
    private TreeNode construct(int[] nums,int start,int end){
        if(start>=end) return null;
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left=construct(nums,start,maxIndex);
        root.right=construct(nums,maxIndex+1,end);
        return root;
    }
    private int findMaxIndex(int[] nums,int start,int end){
        int[] record=new int[]{nums[start],start};
        for(int i=start+1;i<end;i++){
            if(nums[i]>record[0]){
                record[0]=nums[i];
                record[1]=i;
            }
        }
        return record[1];
    }

}
