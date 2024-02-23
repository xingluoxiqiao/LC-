package HOT_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Solution_28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return -1;
        int[] next =new int[needle.length()];
        getNext(next,needle);
        int j=0;
        for(int i=0;i<haystack.length();i++){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
            if(j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String s) {
        //既是字串前后缀相同字符个数也是对应的回溯索引
        int j=0;
        //next数组存放当前字符前面距离最近的相同字符的下标
        next[0]=0;
        for(int i=1;i<s.length();i++){
            //while和if的顺序不能颠倒，因为if会修改j的值，导致while的判断有误
            //而while虽然修改了j的值，但是不会影响if的判断，因为本来就是回溯后判断
            while(j>0&&s.charAt(i)!=s.charAt(j)){
                //当前字符不同，回溯到前缀的最后一个字符，一直回溯直到为0
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            //j>0表明有回溯的可能（不大于0只可能为0），否则直接将next[i]赋为0
            next[i]=j;
        }
    }
}

