package 代码随想录二刷.字符串;

import java.lang.ref.PhantomReference;

//找出字符串中第一个匹配项的下标
public class _28_KMP {
    public int strStr(String haystack, String needle) {
        int[] next=getNext(needle);
        int j=0;
        for(int i=0;i<haystack.length();i++){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)) j=next[j-1];
            if(haystack.charAt(i)==needle.charAt(j)) j++;
            if(j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    private int[] getNext(String s){
        //next数组存放的是不相等时应该返回的下标
        int[] next=new int[s.length()];
        //表示当前下标
        int j=0;
        next[0]=0;
        for(int i=1;i<s.length();i++){
            //当前字符与前面的字符不匹配时，下标j应该回退到上一步存储的位置
            //由于可能不止回退一次，因此是while
            while(j>0&&s.charAt(i)!=s.charAt(j)) j=next[j-1];
            if(s.charAt(i)==s.charAt(j)) j++;
            next[i]=j;
        }
        return next;
    }

}
