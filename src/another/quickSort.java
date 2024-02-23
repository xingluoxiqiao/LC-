package another;

public class quickSort {
    //快排
    public static int QuickfindKthLargest(int[] nums, int k) {
        // 快速排序
        quickSort(nums, 0, nums.length - 1);
        // 第k大的数即为数组中的第nums.length - k个元素
        return nums[nums.length - k];
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(nums, low, high);
            quickSort(nums, low, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 4;
        int result = QuickfindKthLargest(nums, k);
        System.out.println("无序数组中第" + k + "大的数是：" + result);
    }
}
