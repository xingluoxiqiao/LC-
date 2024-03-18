package 笔试合集;

import java.util.Arrays;
import java.util.Scanner;

public class meituan_3_9 {
//    MT 是美团的缩写，因此小美很喜欢这两个字母。现在小美拿到了一个仅由大写字母组成字符串，她可以最多操作k次，
//    每次可以修改任意一个字符。小美想知道，操作结束后最多共有多少个'M' 和'T' 字符?
//    输入  两个正整数n和k，代表字符串长度和操作次数 第二行输入一个长度为n的、仅由大写字母组成的字符串。
//    约束条件  1≤k≤n≤10^5
//    输出  操作结束后最多共有多少个'M' 和'T'字符
    public int countMT(int n,int k,String s){
        int res=k;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='M'||s.charAt(i)=='T'){
                res++;
            }
        }
        return Math.min(res, n);
    }

//    小美拿到了一个由正整数组成的数组，但其中有一些元素是未知的(用0来表示)。现在小美想知道，
//    如果那些未知的元素在区间[l,r]范围内随机取值的话，数组所有元素之和的最小值和最大值分别是多少?共有q次询问
//    输入描述
//    第一行输入两个正整数n和 q，代表数组大小和询问次数。
//    第二行输入 n个整数 ai，其中如果输入的ai为0，那么说明ai是未知的。
//    接下来的 q行，每行输入两个正整数 l 和r，代表一次询问。
//    约束条件
//            1≤n,q≤10^5
//            0≤a_i≤10^9
//            1≤l≤r≤10^9
//    输出描述
//    输出 q行，每行输出两个正整数，代表所有元素之和的最小值和最大值。
    public int[][] minAndMax(int n,int q,int[] arr,int[][] queries) {
        int arrSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) count++;
            arrSum += arr[i];
        }
        int[][] res = new int[q][2];
        for (int i = 0; i < q; i++) {
            res[i][0] = arrSum + count * queries[i][0];
            res[i][1] = arrSum + count * queries[i][1];
        }
        return res;
    }

//    小美拿到了一个 nxn 的矩阵，其中每个元素是0或者1。小美认为一个矩形区域是完美的，当且仅当该区域内0的数量恰好等于1的数量。
//    现在，小美希望你回答有多少个ixi的完美矩形区域。你需要回答1≤i≤n的所有答案。
//    输入描述
//    第一行输入一个正整数 n，代表矩阵大小。
//    接下来的 n行，每行输入一个长度为n的 01串，用来表示矩阵
//    约束条件    1≤n≤200
//    输出描述
//    输出n行，第i行输出 ixi的完美矩形区域的数量。
    public void perfectRectangle(int n,int[][] matrix) {
        int[][] dp = new int[n + 1][n + 1];
        Scanner in=new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            String input = in.nextLine();
            int[] s = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int su = 0;
            for (int j = 1; j <= n; j++) {
                su += s[j - 1];
                dp[i][j] = dp[i - 1][j] + su;
            }
        }
        for (int i = 1; i <= n; i++) {
            int res = 0;
            if (i % 2 == 0) {
                System.out.println(0);
            } else {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= n; k++) {
                        int num = dp[j][k] - dp[j][k - i] - dp[j - i][k] + dp[j - i][k - i];
                        if (num == i * i / 2) {
                            res++;
                        }
                    }
                }
                System.out.println(res);
            }
        }
    }


//    小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积未尾至少有k个0。小美想知道，一共有多少种不同的删除方案?
//    输入描述
//    第一行输入两个正整数n和 k。
//    第二行输入n个正整数 ai，代表小美拿到的数组。
//    约束条件  1≤n,k≤10^5
//             1≤ai≤10^9
//    输出描述
//    一个整数，代表删除的方案数。
    public int deleteCount(int n,int k,int[] arr){
        int[] pre2=new int[n+1];
        int[] pre5=new int[n+1];
        int total2=0,total5=0;
        for(int i=0;i<n;i++) {
            int cnt2=countNumber(arr[i],2);
            int cnt5=countNumber(arr[i],5);
            total2+=cnt2;
            total5+=total5;
            pre2[i+1]=pre2[i]+cnt2;
            pre5[i+1]=pre5[i]+cnt5;
        }
        int res=0;
        for(int i=0,j=0;i<n;i++){
            while(j<n){
                int cnt2=pre2[j+1]-pre2[i];
                int cnt5=pre5[j+1]-pre5[i];
                int remain2=total2-cnt2,remain5=total5-cnt5;
                if(Math.min(remain2,remain5)>=k){
                    j++;
                }else break;
            }
            res+=Math.max((j-i),0);
        }
        return res;
    }
    public int countNumber(int m,int mod){
        int res=0;
        while(m!=0){
            if(m%mod==0) res++;
            else break;
            m/=mod;
        }
        return res;
    }




}
