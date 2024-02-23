package hot100;

import java.util.Arrays;
import java.util.Random;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution_169 {
    //排序取中值
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    //随机取一个数，然后统计这个数出现的次数，大于一半则返回这个数（时间复杂度可能是无穷，6）
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    public int majorityElement2(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }


    //投票法（多数元素的数量足以让它将其它元素抵消还有剩）
    //注意候选者的改变时机
    //一个数作为候选者时，如果被抵消成0，它就应该让位了，因为真正的强者不会被抵消成0
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }



}
