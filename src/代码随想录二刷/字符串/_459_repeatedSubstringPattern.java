package 代码随想录二刷.字符串;
//重复的子字符串
public class _459_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] next=getNext(s);
        //数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，
        //如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        if(next[s.length()-1] > 0&&s.length()%(s.length()-next[s.length()-1])==0){
            return true;
        }
        else {
            return false;
        }
    }

    public int[] getNext(String s){
        int[] next=new int[s.length()];
        int j=0;
        next[0]=0;
        for(int i=1;i<s.length();i++){
            while(j>0&&s.charAt(i)!=s.charAt(j)) j=next[j-1];
            if(s.charAt(i)==s.charAt(j)) j++;
            next[i]=j;
        }
        return next;
    }
 }
