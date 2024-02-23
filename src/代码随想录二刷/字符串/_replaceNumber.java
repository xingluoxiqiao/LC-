package 代码随想录二刷.字符串;
//替换数字

/**
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 */
public class _replaceNumber {
        public static String replaceNumber(String s){
            char[] chs=s.toCharArray();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<chs.length;i++){
                if(Character.isDigit(chs[i])) {
                    sb.append("number");
                }
                else{
                    sb.append(chs[i]);
                }
            }
            return sb.toString();
        }
    }
