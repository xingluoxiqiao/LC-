package 代码随想录二刷.字符串;

//反转字符串II
public class _541_reverseStringII {
    public String reverseStr(String ch, int k) {
        char[] chs=ch.toCharArray();
        char temp;
        for(int i=0;i<chs.length;i+=2*k){
            int begin=i;
            int end=Math.min(chs.length-1,begin+k-1);
            while(begin<end){
                temp=chs[begin];
                chs[begin]=chs[end];
                chs[end]=temp;
                begin++;
                end--;
            }
        }
        return new String(chs);
    }
}
