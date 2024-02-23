package 代码随想录二刷.栈与队列;

import java.util.Stack;

//有效的括号
public class _20_ValidParentheses {
    public static boolean isValid(String s) {
        char[] chs=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char c:chs){
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||c!=stack.peek()){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
