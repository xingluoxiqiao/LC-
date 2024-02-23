package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        //用一个数组记录s，p两个字符串中各字母的数量差值
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }
        //找出有几个字母的数量差值不为0
        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }
        //当前 数量不一样的字母 数量为0时，保存一个结果0
        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            //开始滑动窗口
            // 假设现在把s[i]去掉（窗口向后滑动一格）会发生的情况
            // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同（去掉前）变得相同（去掉后）
            if (count[s.charAt(i) - 'a'] == 1) {
                --differ;
                // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
            } else if (count[s.charAt(i) - 'a'] == 0) {
                ++differ;
            }
            // 假设现在把s[i+plen]加上（窗口向后滑动一格）会发生的情况
            // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                --differ;
                // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                ++differ;
            }
            //窗口正式向后滑动一格，左侧字母数量-1，右侧字母数量+1
            --count[s.charAt(i) - 'a'];
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}
