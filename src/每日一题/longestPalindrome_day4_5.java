package 每日一题;
//最长回文字串
public class longestPalindrome_day4_5 {
    //中心扩散
    public String longestPalindrome(String s) {
        if(s.length()==0||s==null) return "";
        int strLen=s.length();
        int maxLen=0;
        int len=1;
        int maxStart=0;
        int left=0,right=0;

        for(int i=0;i<strLen;i++){
            left=i-1;
            right=i+1;
            while(left>=0&&s.charAt(i)==s.charAt(left)){
                left--;
                len++;
            }
            while(right<strLen&&s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }
            while(right<strLen&&left>=0&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                len+=2;
            }
            if(len>maxLen){
                maxLen=len;
                maxStart=left;
            }
            len=1;
        }
        return s.substring(maxStart+1,maxLen+maxStart+1);
    }

    //动态规划，空间换时间
    public String longestPalindrome2(String s) {
        if(s.length()<2||s==null) return s;
        int strLen=s.length();
        int maxStart=0;
        int maxLen=1;
        //dp[i][j]为true表示i-j是回文字串
        boolean[][] dp=new boolean[strLen][strLen];
        for(int i=0;i<strLen;i++){
            dp[i][i]=true;
        }
        //字串长度，从2开始
        for(int len=2;len<=strLen;len++){
            //左边界
            for(int i=0;i<strLen;i++){
                //右边界
                int j=i+len-1;
                if(j>=strLen){
                    break;
                }
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else{
                    //当前字串只有两个字符并且这两个字符相等，一定是回文字串
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        //左右边界相等，是否是回文字串取决于中间
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    maxStart=i;
                }
            }
        }
        return s.substring(maxStart,maxStart+maxLen);
    }
}