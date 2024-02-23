package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  131. 分割回文串
 *  给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 */
public class Solution_131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }
    public static void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(!isValid(s, start, i)) continue;
            path.add(s.substring(start, i + 1));
            backtrack(s, i + 1, path, res);
            path.remove(path.size() - 1);

        }
    }

    // 判断是否是回文串,双指针法
    public static boolean isValid(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
