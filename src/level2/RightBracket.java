package level2;

import java.util.Stack;

public class RightBracket {
    public static void main(String[] args) {
        solution("()()");
    }

    /**
     * 올바른 괄호 (https://school.programmers.co.kr/learn/courses/30/lessons/12909)
     *
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.charAt(0) != '(') return false;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.size() == 0) return false;
                stack.pop();
            }
        }

        if (stack.size() == 0) return true;
        else return false;
    }
}
