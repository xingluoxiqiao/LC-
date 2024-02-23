package hot100;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Solution_189 {
    //新建数组，取后k个元素临时放着，然后再组合
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - k; i < nums.length; i++) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
    //先反转，再反转
    public void rotate2(int[] nums, int k){
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //环状替换（例如：当前元素下标为n，它应该后移k格，下标为n+k的元素也要后移k格，如果n+k+k已经超出了数组长度，减一个数组长度就行（统一模一下））
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        //求最大公约数（辗转相除法）
        return y > 0 ? gcd(y, x % y) : x;
    }
}
