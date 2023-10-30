package level1;

import java.util.Arrays;
import java.util.HashMap;

public class NumberString_0620 {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    /**
     * 없는 숫자 더하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/86051)
     *
     * @param s 문자열
     * @return
     */
    public static int solution(String s) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        String temp = "";
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
                continue;
            }

            temp += s.charAt(i);
            if (map.containsKey(temp)) {
                answer += map.get(temp);
                temp = "";
            }
        }

        return Integer.parseInt(answer);
    }

}
