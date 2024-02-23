package 代码随想录二刷.贪心算法;

import java.util.Arrays;

//跳跃游戏
public class _55_canJump {
    //每次都更新能跳到的最远处
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int max=0;
        for(int i=0;i<nums.length;i++){
            //一旦i超过max了就必须立即返回false，如果放在最后判断就不对了
            if(i>max) return false;
            int temp=i+nums[i];
            max=temp>max?temp:max;
            if(max>nums[nums.length-1]) return true;
        }
        return false;
    }
}
