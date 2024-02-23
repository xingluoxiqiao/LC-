package hot100;
import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution_22 {
    //根据题意只有”（）“一种括号，因此”有效“只需判断是否左括号数量大于右括号数量，且左括号数量小于n即可
        public List<String> generateParenthesis(int n) {
            List<String> res=new ArrayList<>();
            backTracking(res,new StringBuilder(),0,0,n);
            return res;
        }
        private void backTracking(List<String> res,StringBuilder cur,int open,int close,int max){
            if(cur.length()==max*2){
                res.add(cur.toString());
            }
            if(open<max){
                cur.append('(');
                backTracking(res,cur,open+1,close,max);
                cur.deleteCharAt(cur.length()-1);
            }
            if (close < open) {
                cur.append(')');
                backTracking(res, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

