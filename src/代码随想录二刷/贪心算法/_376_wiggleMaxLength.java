package 代码随想录二刷.贪心算法;
//摆动序列
public class _376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int prediff=0;
        int curdiff=0;
        int result=1;
        for (int i = 0; i < nums.length-1; i++) {
            curdiff=nums[i+1]-nums[i];
            if (curdiff>0&&prediff<=0||curdiff<0&&prediff>=0) {
                result++;
                prediff=curdiff;
            }
        }
        return result;
    }
}
