package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution_17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        //用字符串数组来存储每个数字对应的字母
        String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        backtracking(digits, 0, strs, res, "");
        return res;
    }

    /**
     * @param digits 当前输入的数字
     * @param index  因为是排列，不可重复，记录当前遍历到的位置
     * @param strs   所有可能的字母
     * @param res    结果集
     * @param s      每一步组成的中间字符串，用于回溯
     */
    public static void backtracking(String digits, int index, String[] strs, List<String> res, String s) {
        //每按下一个键输入一个字母，输入个数相同时记录一个结果
        if(s.length()==digits.length()){
            res.add(s);
            return;
        }
        //获取当前按下的数字对应的可能的所有字母组成的字符串
        String str = strs[digits.charAt(index) - '2'];
        for(int i=0;i<str.length();i++){
            backtracking(digits, index+1, strs, res, s+str.charAt(i));
        }
    }
}
