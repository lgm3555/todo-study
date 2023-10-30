package level2;

import java.util.Arrays;

public class InterceptSystem {
    public static void main(String[] args) {
        InterceptSystem interceptSystem = new InterceptSystem();
        interceptSystem.solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
    }

    /**
     * 요격 시스템 (https://school.programmers.co.kr/learn/courses/30/lessons/181188)
     *
     * @param targets
     * @return
     */
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, ((x, y) -> x[0] - y[0]));

        int preStart = targets[0][0];
        int preEnd = targets[0][1];

        System.out.println("preStart = " + preStart);
        System.out.println("preEnd = " + preEnd);

        for (int[] target : targets) {
            if (answer == 0) {
                answer += 1;
                continue;
            }

            int curStart = target[0];
            int curEnd = target[1];

            if (preStart <= curStart && curStart < preEnd) {
                // 요격 구간이 계속 변경
                // 시작 구간은 더 큰 값을 기준으로 변경
                // 끝 구간은 더 작은 값을 기준으로 변경
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                preStart = curStart;
                preEnd = curEnd;
                answer += 1;
            }
        }

        return answer;
    }
}
