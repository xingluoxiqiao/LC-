package hot100;

/**
 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 子数组 是数组中的一个连续部分。
 */
public class Solution_53 {
    //代码随想录.二叉树.动态规划
    public int maxSubArray(int[] nums) {
        //dp[n]是以nums[n]结尾的最大连续子数组和
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    //线段树（分治法）虽然复杂度和动态规划一样，但是可以求到nums数组中任一区间的最大子段和
    //内部类用于维护某个区间的四个值
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
//            lSum 表示 [l,r] 内以 l为左端点的最大子段和
//            rSum表示 [l,r] 内以 r 为右端点的最大子段和
//            mSum表示 [l,r] 内的最大子段和
//            iSum表示 [l,r] 的区间和
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        //数组大小为1（左边界等于右边界时），四个值都是数组元素
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        //求中间索引（相当于除2）
        int m = (l + r) >> 1;
        //递归求左右子区间的信息
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        //已知某个区间被分成两个子区间各自的信息，可以得到这个大区间的信息
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
