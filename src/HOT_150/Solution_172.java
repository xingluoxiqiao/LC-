package HOT_150;

/**
 *给定一个整数 n ，返回 n! 结果中尾随零的数量。
 */

/**
 * 每5个数中就有一个是5的倍数，每25个数中就有一个是25（两个5已经算了一个）的倍数，每125个数...
 */
public class Solution_172 {
    public int trailingZeroes(int n) {
        int ans=0;
        while(n!=0){
            n/=5;
            ans+=n;
        }
        return ans;
    }



}