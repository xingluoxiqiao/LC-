package hot100;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class Solution_287 {
    //环状替换
    public int findDuplicate2(int[] nums){
        //利用第一个元素作为temp，使每个元素都回到它的索引所在的位置
        while(nums[0]!=nums[nums[0]]) swap(nums,nums[0],nums[nums[0]]);
        return nums[nums[0]];
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //这个问题和环状链表有点像，因为数组的索引可以看作是链表节点的值，而它每个元素则指向下一个节点
    //因此，如果链表中有两个节点指向了同一个节点，那么一定有环
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        //快指针每次走两步，慢指针每次走一步
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        //将其中一个指针指向头，两个指针速度一致，第二次相遇就是入环口
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
