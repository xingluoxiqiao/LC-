package 代码随想录二刷.字符串;

//反转字符串
public class _344_reverseString {
    public void reverseString(char[] s) {
        int left=0,right=s.length-1;
        char temp;
        while(left<right){
            temp=s[right];
            s[right]=s[left];
            s[left]=temp;
            left++;
            right--;
        }
    }
}
