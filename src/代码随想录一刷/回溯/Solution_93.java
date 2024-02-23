package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  93. 复原 IP 地址
 *  有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class Solution_93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String>  res= new ArrayList<>();
        backtracking(s,0,0,new StringBuilder(),res);
        return res;
    }

    public static void backtracking(String s,int start,int pointNum,StringBuilder sb,List<String> res) {
        //加上了三个点收集结果
        if (pointNum == 3) {
            //前面的三段在递归时判断，这里只需要判断第四段是否合规
            if (isValid(s, start, s.length() - 1)) {
                res.add(sb.toString() + s.substring(start, s.length()));
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                sb.append(s.substring(start, i + 1) + ".");
                //pointNum记录'.'的个数，回溯隐藏在参数里
                backtracking(s, i + 1, pointNum + 1, sb, res);
                //代码随想录.二叉树.回溯，把点也去掉
                sb.delete(sb.length() - (i + 2 - start), sb.length());
            }
        }

    }
    //判断'.'前的字符串是否合法
    public static boolean isValid(String s,int start, int end){
        if(start>end) return false;
        if(s.charAt(start)=='0' && start!=end) return false;
        int num=0;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)>'9' || s.charAt(i)<'0') return false;
            num=num*10+(s.charAt(i)-'0');
        }
        return num>=0 && num<=255;
    }

}
