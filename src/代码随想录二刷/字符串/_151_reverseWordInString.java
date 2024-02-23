package 代码随想录二刷.字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//翻转字符串中的单词
public class _151_reverseWordInString {
    public String reverseWords(String s){
        s=s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);
    }
}
