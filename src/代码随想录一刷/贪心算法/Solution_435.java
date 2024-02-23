package 代码随想录一刷.贪心算法;

import java.util.Arrays;

/**
 *  435. 无重叠区间
 *  给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 *  返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 思路：
 * 贪心在于：当两个区间重叠时，每次都选择右边界更小的区间，这样能保证不重叠区间的数量最大
 */
public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //按左边界从小到大排序
        int count = 0;
        Arrays.sort(intervals,  (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=1;i<intervals.length;i++){
            //重叠，更新最小右边界
            if(intervals[i][0]<intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
                count++;
            }
        }
        return count;
    }
}
