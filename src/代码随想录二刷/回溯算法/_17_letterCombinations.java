package 代码随想录二刷.回溯算法;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//电话号码的字母组合
public class _17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return new ArrayList<>();
        String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res=new ArrayList<>();
        backTracking(digits,0,res,"",strs);
        return res;
    }
    private void backTracking(String digits,int startIndex,List<String> res,String path,String[] strs){
        if(path.length()==digits.length()){
            res.add(path);
            return;
        }
        String str=strs[digits.charAt(startIndex)-'2'];
        for(int i=0;i<str.length();i++){
            backTracking(digits,startIndex+1,res,path+str.charAt(i),strs);
        }

    }
}
