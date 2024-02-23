package 代码随想录一刷.贪心算法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  56. 合并区间
 *  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *  请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *  思路：
 *  重叠了更新左边界，没重叠更新右边界，加入结果集
 */
public class Solution_56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //结果集大小未知，用list先存着
        List<int[]> res = new LinkedList<>();
        for(int i=1;i<intervals.length;i++){
            //如果两个区间有交集，更新右边界为较大的那个,更新左边界为较小的那个
            if(intervals[i][0]<=intervals[i-1][1]){
                intervals[i][1] = Math.max(intervals[i][1],intervals[i-1][1]);
                intervals[i][0] = Math.min(intervals[i][0],intervals[i-1][0]);
            }//否则将这个区间加入结果集
            else{
                res.add(new int[]{intervals[i - 1][0], intervals[i - 1][1]});
            }
        }
        //最后一个区间需要另外处理，这里的intervals已经处理过，就算是重叠的也可以直接加入
        res.add(new int[]{intervals[intervals.length-1][0],intervals[intervals.length-1][1]});
        return res.toArray(new int[res.size()][]);
    }

    //这种写法更加简单易懂
    public int[][] merge1(int[][] intervals) {
            List<int[]> res = new LinkedList<>();
            //按照左边界排序
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
            //initial start 是最小左边界
            int start = intervals[0][0];
            int rightmostRightBound = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                //如果左边界大于最大右边界
                if (intervals[i][0] > rightmostRightBound) {
                    //加入区间 并且更新start
                    res.add(new int[]{start, rightmostRightBound});
                    start = intervals[i][0];
                    rightmostRightBound = intervals[i][1];
                } else {
                    //更新最大右边界
                    rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
                }
            }
            res.add(new int[]{start, rightmostRightBound});
            return res.toArray(new int[res.size()][]);
        }
    }

