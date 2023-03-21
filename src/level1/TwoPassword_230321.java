package level1;

import java.util.ArrayList;

public class TwoPassword_230321 {
    public static void main(String[] args) {
        solution("y", "az", 1);
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/155652
     *
     * @param s 문자열
     * @param skip 패스 문자
     * @param index 순번
     * @return
     */
    public static String solution(String s, String skip, int index) {
        String answer = "";

        ArrayList<Integer> skipList = new ArrayList<>();

        for (int i=0; i<skip.length(); i++) {
            skipList.add((int) skip.charAt(i));
        }

        for (int i=0; i<s.length(); i++) {
            int k = index;
            int temp = (int) s.charAt(i);

            while (true) {
                temp++;
                if (temp == 123) temp = 97;
                if (!skipList.contains(temp)) k--;

                if (k == 0) break;
            }

            answer += String.valueOf((char) temp);
        }

        return answer;
    }
}