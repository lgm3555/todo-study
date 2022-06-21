package level1;

import java.util.Arrays;
import java.util.TreeSet;

public class SumMinusResult {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true, false, true};

        System.out.println(solution(absolutes, signs));
    }

    /**
     * 음양 더하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/76501)
     *
     * @param absolutes 숫자 리스트
     * @param signs 음, 양 리스트
     * @return
     */
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i=0; i<absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
