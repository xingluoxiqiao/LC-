package another;

import java.util.Arrays;

    public class Solution {
        public static void main(String[] args) {
            System.out.println(maxN(new int[]{4,5}, 532));
        }

        // 贪心加二分
        public static int maxN(int[] digits,int n){
            Arrays.sort(digits);
            String str= n + "";
            // 从最高位开始寻找小于等于当前位的数
            boolean less = false;
            int res=0;
            for(int i=0;i<str.length();i++){
                //num是n的第i-1位数
                int num = str.charAt(i)-'0';
                if(less) {
                    //如果已经找到了，后面的数都变为最大数
                    res=res*10+(digits[digits.length-1]);
                    continue;
                }
                // 二分寻找小于等于num的第一个数
                int r = binarySearch(digits,num,i<str.length()-1 ? str.charAt(i+1)-'0' : digits[0]);
                // 1. 存在小于当前位的数,后续位之间取最大值
                if(r<num){
                    res=res*10 + r;
                    less=true;
                }
                // 2. 存在等于当前位的数,继续寻找小于后续位的数
                else if(r==num){
                    res=res*10 + r;
                }
                // 3. 不存在小于当前位的数,返回-1
                //走到这里说明没有任何一位是大于数组中给的数的，返回-1
                else return -1;
            }
            return res;
        }

        // 返回小于等于target的第一个数
       public static int binarySearch(int[] digits,int target,int next){
            // 如果下一个数比digits数组中任何一个数都要小,那么当前target只能找小于的数,不能找等于的数
            if(next<digits[0]) target--;
            int b=0,e=digits.length-1;
            while(b<=e){
                int m=(b+e)>>1;
                if(e-b<=1){
                    if(digits[e]<=target) return digits[e];
                    if(digits[b]<=target) return digits[b];
                    return digits[b];
                }else if(digits[m]==target) return target;
                else if(digits[m]>target) e=m-1;
                else b=m;
            }
            return digits[b];
        }
    }
