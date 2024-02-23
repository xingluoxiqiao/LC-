package 代码随想录二刷.贪心算法;
//分发糖果
public class _135_candy {
    public int candy(int[] ratings) {
        //孩子有左右相邻，需要从左和从右分别遍历一遍，找到两次的最大值
        int[] candy=new int[ratings.length];
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }else{
                candy[i]=1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        int sum=0;
        for(int i=0;i<candy.length;i++){
            sum+=candy[i];
        }
        return sum;
     }
}
