package 代码随想录二刷.数组;
//螺旋矩阵
public class _59_generateMatrix {
    public int[][] generateMatrix(int n) {
        //每一圈是一个循环
        int loop=0;
        int i,j;
        //每次循环从res[start][start]开始
        int start=0;
        int count=1;
        int[][] res=new int[n][n];
        while(loop++ <n/2){
            for(j=start;j<n-loop;j++){
                res[start][j]=count++;
            }
            for(i=start;i<n-loop;i++){
                res[i][j]=count++;
            }
            for(;j>=loop;j--){
                res[i][j]=count++;
            }
            for(;i>=loop;i--){
                res[i][j]=count++;
            }
            start++;
        }
        if(n%2==1){
            res[start][start]=count++;
        }
        return res;
    }
}
