package 代码随想录二刷.哈希表;
//有效字母异位词
public class _242_isAnagram {
    public boolean isAnagram(String s, String t){
        if(s.length()!=t.length()) return false;
        int[] hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for(int j=0;j<26;j++){
            if(hash[j]!=0){
                return false;
            }
        }
        return true;
    }
}
