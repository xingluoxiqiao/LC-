package 代码随想录二刷.回溯算法;

import java.util.ArrayList;
import java.util.List;

//分割回文串
public class _131_partition {
    List<List<String>> res=new ArrayList<>();
    List<String> path=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==0||s.isEmpty()) return new ArrayList<>();
        backTracking(s,0);
        return res;
    }
    private void backTracking(String s,int index){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i=index;i<s.length();i++){
            if(!isValid(s,index,i)) continue;
            //subString是左闭右开的
            path.add(s.substring(index,i+1));
            backTracking(s,i+1);
            path.remove(path.size()-1);
        }
    }
    private boolean isValid(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
