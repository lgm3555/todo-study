package level1;

import java.util.Arrays;

public class NoneNumberSum_0620 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        System.out.println(solution(numbers));
    }

    /**
     * 없는 숫자 더하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/86051)
     *
     * @param numbers 숫자 리스트
     * @return
     */
    public static int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
