package 代码随想录二刷.二叉树;

import java.util.ArrayList;
import java.util.List;

//二叉树所有路径
public class _257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        backTracking(res,root,"");
        return res;

    }
    private void backTracking(List<String> res,TreeNode root,String str){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            res.add(new StringBuilder(str).append(root.val).toString());
            return;
        }
        //回溯隐藏在这里
        String temp=new StringBuilder(str).append(root.val).append("->").toString();
        backTracking(res,root.left,temp);
        backTracking(res,root.right,temp);
    }


}
