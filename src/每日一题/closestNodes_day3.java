package 每日一题;

import java.util.ArrayList;
import java.util.List;
//二叉搜索树最近节点查询
//中序遍历+二分查找
public class closestNodes_day3 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr=new ArrayList<>();
        dfs(root,arr);
        List<List<Integer>> res=new ArrayList<>();
        for(int val:queries){
            int maxVal=-1,minVal=-1;
            int idx=binarySearch(arr,val);
            //idx=集合大小时，表明它大于集合中的任何一个数
            if (idx != arr.size()) {
                maxVal = arr.get(idx);
                if (arr.get(idx) == val) {
                    minVal = val;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(minVal);
                    list.add(maxVal);
                    res.add(list);
                    continue;
                }
            }
            if (idx > 0) {
                minVal = arr.get(idx - 1);
            }
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(minVal);
            list2.add(maxVal);
            res.add(list2);
        }
        return res;
    }
    //中序遍历二叉搜索树得到的是有序数组
    private void dfs(TreeNode root,List<Integer> list){
        if(root==null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
    private int binarySearch(List<Integer> list,int target){
        int low=0,high=list.size();
        while(low<high){
            int mid=low+(high-low)/2;
            if(list.get(mid)>=target){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
 }
