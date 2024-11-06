package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FuncDevelop {
    public static void main(String[] args) {
        //solution(new int[] {93, 30, 55}, new int[]{1, 30, 5}); //2,1
        solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}); //	[1, 3, 2]
    }

    /**
     * 기능개발 (https://school.programmers.co.kr/learn/courses/30/lessons/42586)
     *
     * @param progresses
     * @param speeds
     * @return
     */
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int a = 100 - progresses[i];
            int c = a % speeds[i] > 0 ? 1 : 0;

            int b = (a / speeds[i]) + c;
            queue.add(b);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int answer = 1;
        int first = queue.poll();

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (first >= poll) {
                answer++;
            } else {
                temp.add(answer);
                first = poll;
                answer = 1;
            }

            if (queue.isEmpty()) {
                temp.add(answer);
            }
        }

        int[] result = new int[temp.size()];
        for (int i=0; i<temp.size(); i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}
