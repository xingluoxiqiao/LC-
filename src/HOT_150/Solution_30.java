package HOT_150;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"，
 * "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 */
//思路：由于所有单词的长度相同，可以将每个单词抽象为一个“字符”，考虑使用滑动窗口，即“字符异位词”
public class Solution_30 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res =new ArrayList<>();
            int m=words.length,n=words[0].length(),ls=s.length();
            for(int i=0;i<n;i++){
                if(i+m*n>ls){
                    break;
                }
                Map<String,Integer> differ = new HashMap<String,Integer>();
                //将s切为m个长度为n的小串（单词），记录每个单词出现的次数
                for(int j=0;j<m;j++){
                    String word = s.substring(i+j*n,i+(j+1)*n);
                    differ.put(word,differ.getOrDefault(word,0)+1);
                }
                //计算出现次数的差值
                for(String word:words){
                    differ.put(word,differ.getOrDefault(word,0)-1);
                    if(differ.get(word)==0){
                        differ.remove(word);
                    }
                }
                //start是滑动窗口的左边界
                for(int start=i;start<ls-m*n+1;start+=n){
                    //滑动窗口不是初始值（右移一个单词长度）
                    if(start!=i){
                        //最右侧单词即将进入窗口
                        String word=s.substring(start+(m-1)*n,start+m*n);
                        differ.put(word,differ.getOrDefault(word,0)+1);
                        //当前单词已经全部匹配，移除
                        if(differ.get(word)==0){
                            differ.remove(word);
                        }
                        //最左侧单词即将滑出窗口
                        word=s.substring(start-n,start);
                        differ.put(word,differ.getOrDefault(word,0)-1);
                        //当前单词已经全部匹配，移除
                        if(differ.get(word)==0){
                            differ.remove(word);
                        }
                    }
                    //全部单词都已匹配
                    if(differ.isEmpty()){
                        res.add(start);
                    }
                }
            }
            return res;
        }
}
