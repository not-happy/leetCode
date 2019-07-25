package datastructure.stack;

import java.util.Stack;

/**
 * @author xuyong
 * @since 2019-07-25 15:36
 **/
public class ValidParentheses {

    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != ' ') {
                switch (aChar) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(aChar);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(new ValidParentheses().isValid("()[]{}"));

    }

}
