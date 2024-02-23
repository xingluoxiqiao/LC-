package 代码随想录一刷.回溯;

import java.util.*;

/**
 *  332. 重新安排行程
 *  给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 */

/**
 * 思路：
 * 关键点在于每张机票必须且只能用一次，用used数组来标记
 * 只要找到一条路径即可，所以用回溯，返回值boolean，参数只需要used数组即可，并且used数组应是全局定义的
 * 终止条件：机场数量等于机票数量+1
 * 单层逻辑：因为已经排序，所以遍历获得的第一个符合条件的就可以加入结果集
 * 其中条件是，1.结果集最后一个元素等于现在遍历的list的第一个元素
 *          2.当前机票没有被使用过
 */
class Solution_332 {
    private LinkedList<String> res;
    private LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        //标记第i张票被用过了
        boolean[] used = new boolean[tickets.size()];
        backTracking((ArrayList) tickets, used);
        return res;
    }

    public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;
                //只要找到一条路径直接一路向上返回
                if (backTracking(tickets, used)) {
                    return true;
                }

                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
