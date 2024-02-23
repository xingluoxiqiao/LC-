package 代码随想录二刷.栈与队列;

import java.util.Stack;

//逆波兰表达式求值
public class _150_evalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if (token.equals("+")) {
                    res = num1 + num2;
                } else if (token.equals("-")) {
                    res = num1 - num2;
                } else if (token.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

}
