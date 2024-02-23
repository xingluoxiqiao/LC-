package hot100;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
//雨水=总面积-陆地面积，陆地面积遍历求和
//总面积分层计算，从下到上，每次计算一层，当前层的高度是左右边界中较小的值上次计算的层的高度，即preHeight
//双指针分别找到两端的边界，得到每层的宽度
//总面积等于每层宽度*每层高度之和
public class Solution_42 {
    public int trap(int[] height) {
        //按层来计算雨水+陆地的总面积
        int length = height.length;
        //剪枝，数组长度小于3时不可能接到雨水
        if(length < 3) return 0;
        int l = 0, r = length - 1;

        //定义前一次计算时的高度
        int preHeight = 0;
        //定义雨水 + 陆地的总面积
        int totalArea = 0;
        //定义陆地面积
        int landArea = 0;

        for(int i=0;i<length;i++){
            landArea+=height[i];
        }

        while(l < r) {
            //跳过小于等于前一次计算的值
            while(l < r && height[l] <= preHeight) l++;
            while(l < r && height[r] <= preHeight) r--;

            //计算当前高度的面积 = （当前左右指针中较小的值 - 前一次计算的高度）* 宽度
            totalArea += (Math.min(height[l], height[r]) - preHeight) * (r - l + 1);
            //更新前一次的高度
            preHeight = Math.min(height[l], height[r]);
        }

        return totalArea - landArea;
    }
}
