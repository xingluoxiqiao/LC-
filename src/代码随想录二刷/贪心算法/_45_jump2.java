package 代码随想录二刷.贪心算法;
//跳跃游戏2
public class _45_jump2 {
    //需要考虑下一步的最远覆盖范围
    public int jump(int[] nums) {
        //记录下一步可以跳到的最远距离（当前步+1能到的最远距离）
        int max=0;
        //步数结果
        int res=0;
        //当前步能到的最远范围，如果超过该范围，必须再来一步
        int end=0;
        //不需要管nums[nums.length-1],否则可能多走一步
        for(int i=0;i<nums.length-1;i++){
            //每次都要更新能到的最远
            max=Math.max(i+nums[i],max);
            //已经走到了当前步能到的最远距离
            if(i==end){
                end=max;
                res++;
            }
        }
        return res;
    }
}
