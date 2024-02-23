package hot100;

import java.util.Arrays;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class Solution_136 {
    //    任何数和 0 做异或运算，结果仍然是原来的数
    //    任何数和其自身做异或运算，结果是 0
    //    异或运算满足交换律和结合律
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public int singleNumber2(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
