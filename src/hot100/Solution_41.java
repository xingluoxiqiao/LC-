package hot100;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class Solution_41 {
    //原地交换
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            //不在[1,n]范围内的数，直接跳过
            //在[1,n]范围内的数，交换到对应的位置
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //每个位置上的数都对应正确，返回第一个大于n的数
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    //原地哈希标记法
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        //所有负数改为超出范围，第一次标记所有超出范围的数
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //所有范围内的数对应的下标的数变为负数，相当于标记了这个数在数组中存在
        for (int i = 0; i < n; ++i) {
            //这里要加绝对值，因为可能已经被标记为负数了
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //第一个正数对应的下标，如果为正，说明这个数不在数组中
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

