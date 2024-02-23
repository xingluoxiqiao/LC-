package another;

public class KthLargerst {
        //堆排序
        public static int findKthLargest(int[] nums, int k) {
            // 将数组转换为最大堆
            buildMaxHeap(nums);
            // 进行k-1次堆顶元素删除操作
            for (int i = 0; i < k - 1; i++) {
                swap(nums, 0, nums.length - 1 - i);
                maxHeapify(nums, 0, nums.length - 2 - i);
            }
            // 第k大的数即为当前堆顶元素
            return nums[0];
        }
        private static void buildMaxHeap(int[] nums) {
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                maxHeapify(nums, i, nums.length - 1);
            }
        }
        private static void maxHeapify(int[] nums, int i, int heapSize) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left <= heapSize && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right <= heapSize && nums[right] > nums[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(nums, i, largest);
                maxHeapify(nums, largest, heapSize);
            }
        }
        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public static void main(String[] args) {
            int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
            int k = 4;
            int result = findKthLargest(nums, k);
            System.out.println("无序数组中第" + k + "大的数是：" + result);
        }


}
