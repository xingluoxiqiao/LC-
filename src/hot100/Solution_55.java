package hot100;

/**
 * 跳跃游戏2
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 思路：不要纠结于每一次操作要跳几格，而是每次跳完，更新能跳到的最远距离，在这个距离内都能跳到
 */
public class Solution_55 {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        //当前能跳到的最远距离
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (i>max) return false;
            max=Math.max(max,i+nums[i]);
            if (max>=nums.length-1) return true;
        }
        return false;
    }

}
