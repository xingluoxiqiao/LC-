package 代码随想录二刷.二叉树;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

//二叉搜索树中的众数
public class _501_findMode {
    TreeNode pre;
    int count;
    int maxCount;
    List<Integer> list;
    public int[] findMode(TreeNode root) {
        count=0;
        maxCount=0;
        list=new ArrayList<>();
        pre=null;
        mode(root,list);
        int[] res=new int[list.size()];
        for(int i=0;i< list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
    private void mode(TreeNode root,List<Integer> res){
        if(root==null) return ;
        mode(root.left,res);
        if(pre==null||pre.val!=root.val){
            count=1;
        }else{
            count++;
        }
        if(count>maxCount){
            list.clear();
            list.add(root.val);
            maxCount=count;
        }else if(count==maxCount){
            list.add(root.val);
        }
        pre=root;
        mode(root.right,res);
    }
}
