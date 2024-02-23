package 代码随想录一刷.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后
 *
 * 思路：
 * 返回值void，参数行，列，回溯函数的每一次都是确定一个格子
 * 递归结束条件：row == n
 * 单层逻辑，遍历每行每列
 * 判断是否冲突，冲突则回溯
 * 冲突单拎出来isValid
 */
public class Solution_51 {
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, chessboard);
        return res;
    }
    private static void backtrack(int n, int row, char[][] queens) {
        if (row == n) {
            res.add(Array2List(queens));
            return;
        }
        //for遍历列，递归遍历行，这里其实也可以二维递归，只是每个格子只有两种情况，因此没有必要
        //如果一个格子有多种情况，就可以使用二维递归，for遍历行和列，递归遍历每个可能的结果，如解数独
        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col, queens)) {
                queens[row][col] = 'Q';
                backtrack(n, row + 1, queens);
                queens[row][col] = '.';
            }
        }
    }
    //不用检查行，因为递归每一次只会在一行中放一个皇后
    private static boolean isValid(int n, int row, int col, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }



    private static List<String> Array2List(char[][] queens) {
        List<String> list = new ArrayList<>();
        for (char[] c : queens) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}
