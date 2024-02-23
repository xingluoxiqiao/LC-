package hot100;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution_3 {
    //哈希表法+滑动窗口，每遍历到一个字符，判断哈希表中是否包含该字符，如果包含，则将左指针移到该字符的下一个位置，如果不包含，则将该字符加入哈希表，并更新最大长度
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}