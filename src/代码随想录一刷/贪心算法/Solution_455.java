package 代码随想录一刷.贪心算法;

import java.util.Arrays;

/**
 * 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 思路，从饼干的最大值开始，如果饼干可以满足孩子，则满足，否则饼干值-1，继续判断
 */
public class Solution_455 {
    //g孩子的胃口，s饼干的尺寸
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        int j=0;
        //必须遍历饼干，不能遍历孩子，因为孩子可以满足多个饼干
        for (int i=0;i<s.length&&j<g.length;i++){
            if(s[i]>=g[j]) {
                result++;
                j++;
            }
        }
        return result;
    }
}
