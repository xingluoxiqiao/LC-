package another;

import java.util.Arrays;

/**
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目
 *
 */
public class Solution数位dp {
    char s[];
    int memo[][];

    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        //memeo[i][mask]表示第i位数，已经用了mask状态的所有可能结果
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return f(0, 0, true, false);
    }

    /**
     *这是一个递归函数
     * @param i 当前正在构造第i位（从0开始）
     * @param mask 已经使用过的数，记录使用过的数的状态，需要2的10次方列
     *              比如 1234 已经使用过 1 和 2 了，那么 mask = 110000000（二进制）
     * @param isLimit 当前位是否有限制（前面填的都和n一样），如果是 false 表示当前位没有限制
     * @param isNum 当前位是否填了数字（前一位没填当前位也可以选择不填）
     * @return
     */
   int f(int i, int mask, boolean isLimit, boolean isNum) {
        //确定终止条件
        //当前位已经是最后一位
        if (i == s.length)
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
        //当前位已经记录过，直接返回之前的结果
        if (!isLimit && isNum && memo[i][mask] != -1)
            return memo[i][mask];
        //单层逻辑
        int res = 0;
        if (!isNum) // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        //不能跳过当前数位，需要枚举填入的数字
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        //前面都填了数字就可以填0，否则就要从1开始
        for (int d = isNum ? 0 : 1; d <= up; ++d) { // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) { // d 不在 mask 中（没有被使用过）
                /**
                 * mask | (1 << d)：更新 mask，将当前数字 d 的状态设置为已使用。
                 * 通过 1 << d 将数字 1 左移 d 位，然后使用按位或 | 操作，将这个新的状态合并到原来的 mask 中。
                 * 例如，如果 mask 的二进制表示是 000001000，而 d 是 3，则 (1 << d) 的二进制表示是 000000100，
                 * 通过 | 操作得到新的 mask 是 000001100，表示数字 3 已经被使用。
                 */
                res += f(i + 1, mask | (1 << d), isLimit && (d == up), true);
            }
        }
        if (!isLimit && isNum)  memo[i][mask] = res;
        return res;
    }
}
