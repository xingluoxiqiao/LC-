package 代码随想录二刷.贪心算法;
//柠檬水找零
public class _860_lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum=0;
        int tenNum=0;
        int twentyNum=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) fiveNum++;
            if(bills[i]==10) {
                if(fiveNum>0){
                    fiveNum--;
                    tenNum++;
                }else{
                    return false;
                }
            }
            if(bills[i]==20){
                if(tenNum>0&&fiveNum>0){
                    tenNum--;
                    fiveNum--;
                    twentyNum++;
                }else if(fiveNum>2){
                    fiveNum-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
