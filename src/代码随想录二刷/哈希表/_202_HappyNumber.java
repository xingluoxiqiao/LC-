package 代码随想录二刷.哈希表;

import java.util.HashSet;
import java.util.Set;

//快乐数
public class _202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> record=new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    public int getNextNumber(int n){
        int res=0;
        int temp;
        while(n>0){
            temp=n%10;
            res+=temp*temp;
            n/=10;
        }
        return  res;
    }

}
