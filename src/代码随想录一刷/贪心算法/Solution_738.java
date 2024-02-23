package 代码随想录一刷.贪心算法;

/**
 *  738. 单调递增的数字
 *  当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 *
 * 关键在于数字的遍历顺序，从后往前遍历，可以利用前面的结果，避免在运算后出现新的不符合的情况
 * 如332，从前往后遍历得到329，不符合题意
 * 但从后往前遍历2<3 ,得到329
 * 又有2<3,得到299
 *
 */
public class Solution_738 {
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int start = s.length();
            for (int i = s.length() - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    start = i+1;
                }
            }
            for (int i = start; i < s.length(); i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(String.valueOf(chars));
        }
    }
