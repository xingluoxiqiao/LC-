package 每日一题;

import java.util.*;


public class longestWord_day3_720 {
    //词典中最长的单词
//    给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词 逐步添加一个字母 组成。
//    若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->{
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }else{
                return b.compareTo(a);
            }
        });
        Set<String> candidates=new HashSet<>();
        candidates.add("");
        String longest = "";
        for(String word:words){
            if(candidates.contains(word.substring(0,word.length()-1))){
                candidates.add(word);
                longest=word;
            }
        }
        return longest;
    }

    //字符串中最长的单词长度
    public int longestWordlen(String words){
        String[] strs = words.split("\\s+");
        int len=0;
        for(String str: strs){
            if(str.length()>len){
                len=str.length();
            }
        }
        return len;
    }

    //字符串中最长的单词,如果同样长，返回列表,字符串中含大小写字母，空格，数字，你应该只返回全小写字母组成的单词
    public static List<String> longestWord(String words){
        List<String> res=new ArrayList<>();
        String[] strs = words.split("\\s+");
        int len=0;
        for(String str:strs){
            if(str.length()>len){
                res.clear();
                res.add(str);
                len=str.length();
            }else if(str.length()==len){
                res.add(str);
            }
        }
        return res;
    }
        public static List<String> extractLowercaseWords(String inputString) {
            String[] words = inputString.split("\\s+"); // 使用空格进行分割
            List<String> lowercaseWords = new ArrayList<>();

            for (String word : words) {
                // 判断是否是由字母组成的单词
                if (word.matches("^[a-z]+$")) {
                    lowercaseWords.add(word.toLowerCase());
                }
            }

            return lowercaseWords;
        }


    public static void main(String[] args) {
        String s = new String("caca acavfea caCav s1refcac sacafse");
        System.out.println(extractLowercaseWords(s));
    }
}
