package 代码随想录二刷.栈与队列;

import java.util.Stack;

//删除字符串的所有相邻重复项
public class _1047_removeDuplicates {
    public static String removeDuplicates(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (ch == stack.peek()) {
                stack.pop();
            } else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
