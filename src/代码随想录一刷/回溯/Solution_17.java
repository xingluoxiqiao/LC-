package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution_17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        backtracking(digits, 0, strs, res, "");
        return res;
    }
    public static void backtracking(String digits, int index, String[] strs, List<String> res, String s) {
        if(s.length()==digits.length()){
            res.add(s);
            return;
        }
        String str = strs[digits.charAt(index) - '2'];
        for(int i=0;i<str.length();i++){
            backtracking(digits, index+1, strs, res, s+str.charAt(i));
        }
    }
}
