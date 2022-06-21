package level1;

import java.util.Arrays;
import java.util.TreeSet;

public class TwoNumberSum_0621 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};

        System.out.println(solution(numbers));
    }

    /**
     * 두 개 뽑아서 더하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/68644)
     *
     * @param numbers 숫자 리스트
     * @return
     */
    public static int[] solution(int[] numbers) {
        TreeSet<Integer> answer = new TreeSet<>();
        Arrays.sort(numbers);

        for (int i=0 ;i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
