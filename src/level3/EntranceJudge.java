package level3;

import java.util.Arrays;

//TODO 이분탐색 공부
public class EntranceJudge {
    public static void main(String[] args) {
        EntranceJudge entranceJudge = new EntranceJudge();
        // 0 : 1 2
        // 7 : 3 2
        // 10 : 3 4
        // 14 : 5 4
        // 20 : 5
        // 21 : 6
        // 28
        entranceJudge.solution(6, new int[] {7, 10});
    }

    /**
     * 입국 심사 (https://school.programmers.co.kr/learn/courses/30/lessons/43238)
     *
     * @param n 입국심사 기다리는 사람 수
     * @param times 각 심사관이 한 명을 심사하는데 걸리는 시간 배열
     * @return
     */
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long start = times[0];
        long end = (long) times[times.length - 1] * (long) n;

        long mid;
        long sum = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
