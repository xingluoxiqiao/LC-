package 代码随想录一刷.贪心算法;

import java.util.Arrays;

/**
 *  1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class Solution_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //将数组按照绝对值大小进行排序，可以避免二次排序，
        //因为如果所有负数反转后k还有剩，需要取绝对值最小的正数反转
//        nums = IntStream.of(nums)
//                .boxed()
//                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
//                .mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        //如果k还有剩，说明所有负数都反转了，那么剩下的正数需要取绝对值最小的数反转
        if (k % 2 == 1) {
            Arrays.sort(nums);
            //这里×2是因为上面加了，反转成负数后，不但不能加反而要减
            sum -= 2*nums[0];
        }
        return sum;
    }

}
