package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  763. 划分字母区间
 *  给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 思路：保存每个字母的最大索引
 * 从左往右遍历时，更新最大索引，当最大索引和当前索引相同时，说明当前字母是唯一的，可以划分一个区间
 */
public class Solution_763 {
    public static List<Integer> partitionLabels(String s) {
        // 保存每个字母的最大索引
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        int resIndex = 0;
        //用于计算每个字符串的长度
        int preIndex = 0;
        List<Integer> res = new ArrayList<>();
        //遍历s，每次遍历时获取当前字母的最大索引，用resIndex保存
        for (int i = 0; i < s.length(); i++) {
            resIndex= Math.max(index[s.charAt(i) - 'a'],resIndex);
            //当前索引等于保存的最大索引时，表明前面的所有字母都不会再出现，这时可以保存一个结果
            if(resIndex ==i){
                res.add(resIndex - preIndex + 1);
                preIndex = resIndex + 1;
            }
        }
        return res;
    }

}
