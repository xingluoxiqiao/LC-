package another;

import java.util.Random;

public class QuickOrder {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        //这是之前选出的随机数，交换到了数组末尾
        int pivot = nums[r];
        int i = l - 1;
        //从最左侧开始遍历子数组
        for (int j = l; j <= r - 1; ++j) {
            //当前数小于，则左指针加一，并交换到最左边
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        //遍历完成后交换随机数和左指针下一个
        swap(nums, i + 1, r);
        //返回当前随机数所在索引，左侧全部小于，右侧全部大于
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
