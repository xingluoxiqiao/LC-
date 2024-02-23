package hot100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class Solution_11 {
    //双指针法，装水的多少取决于最左和最右哪边更短
    public int maxArea(int[] height) {
        int left=0;
        int max=0;
        int right=height.length-1;
        while(left<right){
            int height1=Math.min(height[left],height[right]);
            int area=(right-left)*height1;
            max=Math.max(max,area);
            if(height1==height[left]){
                left++;
            }
            if(height1==height[right]){
                right--;
            }
        }
        return max;
    }
}
