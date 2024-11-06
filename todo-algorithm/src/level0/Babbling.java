package level0;

import java.util.List;

public class Babbling {
    public static void main(String[] args) {
        solution(new String[] {"aya", "yee", "u", "maa", "wyeoo"});
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/120956
     *
     * @param babbling
     * @return
     */
    public static int solution(String[] babbling) {
        int answer = 0;
        List<String> list = List.of("aya", "ye", "woo", "ma");

        for (String type : babbling) {
            for (String l : list) {
                type = type.replace(l, " ");
            }
            if ("".equals(type.trim())) {
                System.out.println(type);
                answer++;
            }
        }

        return answer;
    }
}
