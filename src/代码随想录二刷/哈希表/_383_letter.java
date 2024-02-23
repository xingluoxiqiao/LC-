package 代码随想录二刷.哈希表;
//赎金信
public class _383_letter {
    //判断ransomNote是否是magazine的子串
    public boolean canConstruct(String ransomNote, String magazine){
        int[] record = new int[26];
        for(int i=0;i<magazine.length();i++){
            record[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            record[ransomNote.charAt(i)-'a']--;
        }
        for(int j=0;j<26;j++){
            if(record[j]<0){
                return false;
            }
        }
        return true;
    }
}
