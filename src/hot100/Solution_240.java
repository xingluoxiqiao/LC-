package hot100;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Solution_240 {
    //如果从右上角开始寻找的话，某个数大于目标值，这个数一定在目标值下方，可以将行下移，x+1
    //再将现在的右上角和目标值比较，如果小于目标值，这个数一定在目标值的左方，可以将列左移，y-1
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
