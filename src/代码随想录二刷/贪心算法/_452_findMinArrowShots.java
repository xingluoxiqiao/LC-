package 代码随想录二刷.贪心算法;

import java.util.Arrays;

//用最少的箭引爆气球
public class _452_findMinArrowShots {
    //类似于求区间交集
    public int findMinArrowShots(int[][] points) {
        int count=1;
        //先按左边界排序
        //使用Integer内置比较方法，不会溢出
        Arrays.sort(points,  (a, b) -> Integer.compare(a[0], b[0]));
        //比较相邻的两个气球
        for(int i=1;i<points.length;i++){
            //如果两个气球有交集，则更新右边界为两气球中右边界更小的那个
            if(points[i][0]<=points[i-1][1]){
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }else
                count++;

        }
        return count;
    }
}
