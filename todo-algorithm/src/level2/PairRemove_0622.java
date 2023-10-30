package level2;

import java.util.*;

public class PairRemove_0622 {
    public static void main(String[] args) {
        System.out.println(solution1("baabaa"));
    }

    /**
     * 짝지어 제거하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12973)
     *
     * @param s 문자열
     * @return
     */
    public static int solution(String s)
    {
        String[] strArr = s.split("");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArr));

        String temp = list.get(0);

        for (int i=1; i<list.size(); i++) {
            if (temp.equals(list.get(i))) {
                list.remove(i);
                list.remove(i-1);

                i = 0;
                if (list.size() != 0) {
                    temp = list.get(0);
                }
                continue;
            }
            temp = list.get(i);
        }

        return list.size() == 0 ? 0 : 1;
    }
    public static int solution1(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

}

