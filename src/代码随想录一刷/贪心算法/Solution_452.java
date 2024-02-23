package 代码随想录一刷.贪心算法;

import java.util.Arrays;

/**
 *  452. 用最少数量的箭引爆气球
 *  有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 *  其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
 * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * 思路：只要两个气球有交集，一支箭就可以引爆
 * 贪心就是找到最多交集，交集是右和左，不断更新右边界
 */
public class Solution_452 {
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
