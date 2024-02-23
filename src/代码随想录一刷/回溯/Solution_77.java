package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Solution_77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtracking(1,n,k,list,res);
        return res;
    }
    public static void backtracking(int startIndex, int n, int k, LinkedList<Integer> list, List<List<Integer>> res){
        if(list.size()==k){
            //这里不能直接添加list，而应该创建一个新数组，不然会改变list的值
            //这里的arraylist构造函数，相当于将现在list中的值复制了
            //list只是一个中介，一直在被刷新（即使已经添加到了res中），不能直接使用
            res.add(new ArrayList<>(list));
            return;
        }
        //剪枝优化
//        已经选择的元素个数：；list.size();
//        所需需要的元素个数为: k - list.size();
//        列表中剩余元素（n-i） >= 所需需要的元素个数（k - list.size()）
//        在集合n中至多要从该起始位置 : i <= n - (k - list.size()) + 1，开始遍历
//        为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
//        举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
        for(int i=startIndex;i<= n - (k - list.size()) + 1;i++){
            list.add(i);
            backtracking(i+1,n,k,list,res);
            list.removeLast();
        }
    }
}
