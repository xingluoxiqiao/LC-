package HOT_150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class Solution_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        //循环中用的是 Integer i = 0 ，这里已经提前完成了自动装箱，所以循环体内map两次put操作存的value都是同一个Integer对象，不会受到[-128,127]的限制。
        //如果是这样写 for (int i = 0; i < words.length; i++) ，那么在循环体内map两次put操作都会执行自动装箱，会受到[-128,127]的限制。
        //因为每次都会将i放进map中，当i大于127时，就会发生覆盖，导致最后两个map中存的不是同一个Integer对象。
        for (Integer i = 0; i < words.length; i++) {
            //hashmap的返回值
            //如果哈希表中已经包含了给定键，那么新值将替代旧值，并且旧值会被返回。
            //如果哈希表中没有包含给定键，那么这个键值对将被添加到哈希表中，且返回值为 null。
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
