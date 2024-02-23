package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  216. 组合总和 III
 *  找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class Solution_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), res);
        return res;
    }
    private static void dfs(int k, int n, int i, ArrayList<Integer> objects, List<List<Integer>> res) {
        if (objects.size() == k && n == 0) {
            res.add(new ArrayList<>(objects));
            return;
        }
        for (int j = i; j <= 9; j++) {
            objects.add(j);
            dfs(k, n - j, j + 1, objects, res);
            objects.remove(objects.size() - 1);
        }
    }
}
