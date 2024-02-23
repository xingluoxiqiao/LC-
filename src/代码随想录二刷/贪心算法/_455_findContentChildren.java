package 代码随想录二刷.贪心算法;

import java.util.Arrays;

//分发饼干
public class _455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, j = 0;
        for (int i = 0; i < s.length&&j<g.length; i++) {
            if (g[j] <= s[i]) {
                j++;
                res++;
            }
        }
        return res;
    }
}
