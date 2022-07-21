package level2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheBetterSpicy {
    public static void main(String[] args) {
        // 2
        System.out.println(solution(new int[] {1,2,3,9,10,12}, 7));
        // -1
        System.out.println(solution(new int[] {1,2}, 7));
        // 2
        System.out.println(solution(new int[] {1,2,2}, 3));
    }

    /**
     * 더 맵게 (https://school.programmers.co.kr/learn/courses/30/lessons/42626)
     *
     * @param scoville
     * @param K
     * @return
     */
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<scoville.length; i++) {
            if (scoville[i] < K) {
                queue.add(scoville[i]);
            }
        }

        if (queue.size() == 0) return 0;
        boolean check = scoville.length == queue.size();
        while (!queue.isEmpty()) {
            if (queue.peek() > K) break;
            if (queue.size() == 1) {
                if (queue.peek() < K) {
                    if (check) answer = 0;
                    else answer++;
                }
                break;
            } 

            queue.add(queue.poll() + (queue.poll() * 2));
            answer++;
        }

        return answer == 0 ? -1 : answer;
    }
}
