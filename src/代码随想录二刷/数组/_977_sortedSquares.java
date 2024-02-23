package 代码随想录二刷.数组;


//有序数组的平方
public class _977_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int [] res=new int [nums.length];
        int left=0,right=nums.length-1;
        int index=nums.length-1;
        while(left<=right){
            int a=nums[left]*nums[left];
            int b=nums[right]*nums[right];
            if(a<b){
                res[index--]=b;
                right--;
            }else{
                res[index--]=a;
                left++;
            }
        }
        return res;
    }
}
