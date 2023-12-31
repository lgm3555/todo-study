package level2;

import java.util.*;
import java.util.stream.Collectors;

public class SeeSawMate_230328 {
    public static void main(String[] args) {
        // 4
        // 100 = 100
        // 180 * 4 = 360 * 2
        // 180 * 3 = 270 * 2
        // 270 * 4 = 360 * 3
        solution(new int[]{100, 180, 100, 360, 270});
        //solution(new int[]{100, 100, 100});
    }

    private static final int[][] rates = {{1, 1}, {3, 2}, {4, 2}, {4, 3}};

    /**
     * 시소 짝궁 (https://school.programmers.co.kr/learn/courses/30/lessons/152996)
     *
     * @param weights
     * @return
     */
    public static long solution(int[] weights) {
        long answer = 0;

        // 정렬
        Arrays.sort(weights);

        // 비율 만큼 반복
        for (int[] rate : rates) {
            for (int i = 0; i < weights.length; i++) {
                int x = weights[i];

                // 비율 계산을 통해 y를 구함
                if (x * rate[0] % rate[1] != 0) continue;
                
                int findWeight = ((x * rate[0]) / rate[1]);

                // y의 값이 i+1 부터 존재하는지 확인함
                int upper = upperBound(findWeight, weights, i + 1, weights.length);
                // 하한 탐색은 상한 탐색의 위치 이하이므로 탐색 마지막 위치를 upper 해도 됨
                int lower = lowerBound(findWeight, weights, i + 1, upper);

                // 상한과 하한의 값을 빼서 중복된 값이 몇 개 인지 정답에 더함
                // 만약 y의 값이 범위 내에 존재하지 않으면,
                // 상한과 하한 둘 다 i+1의 위치를 반환하기 때문에 둘의 차이는 0이 될 것임
                answer += (upper - lower);
            }
        }

        return answer;
    }

    // 상한
    private static int upperBound(int findWeight, int[] weights, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (findWeight < weights[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 하한
    private static int lowerBound(int findWeight, int[] weights, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (findWeight <= weights[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}