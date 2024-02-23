package 代码随想录一刷.动态规划;

import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
//完全背包，用wordDict中的字符串填满s
public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
//        dp[i]表示前i个字符组成的字符串s是否可以被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                //i-len是之前的已经拼成，i-len到i是一个单词
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
