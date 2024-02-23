package 面经练习;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

//二叉树的所有路径
public class binaryTreePaths {
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        backTracking("",root);
        return res;
    }
    private void backTracking(String str,TreeNode root){
        if(root==null) return;
        if(root.right==null&&root.left==null){
            res.add(new StringBuilder(str).append(root.val).toString());
        }
        String temp=new StringBuilder(str).append(root.val).append("->").toString();
        backTracking(temp,root.left);
        backTracking(temp,root.right);
    }
}
