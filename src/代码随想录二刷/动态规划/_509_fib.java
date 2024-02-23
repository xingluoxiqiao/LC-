package 代码随想录二刷.动态规划;
//斐波那契数
public class _509_fib {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] fin=new int[n];
        fin[0]=1;
        fin[1]=1;
        for(int i=2;i<n;i++){
            fin[i]=fin[i-1]+fin[i-2];
        }
        return fin[n-1];
    }
}
