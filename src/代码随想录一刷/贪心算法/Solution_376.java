package 代码随想录一刷.贪心算法;

/**
 * 摆动序列
 */
public class Solution_376 {

    public int wiggleMaxLength(int[] nums) {
        int prediff=0;
        int curdiff=0;
        //尾部自动视为摆动序列
        int result=1;
        for (int i = 0; i < nums.length-1; i++) {
            curdiff=nums[i+1]-nums[i];
            if (curdiff>0&&prediff<=0||curdiff<0&&prediff>=0) {
                result++;
                //这一步写在if里面，只需要记录序列方向变化，避免了记录平坡的情况
                prediff=curdiff;
            }
        }
        return result;
    }
}

