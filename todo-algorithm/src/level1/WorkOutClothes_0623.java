package level1;

import java.util.ArrayList;

public class WorkOutClothes_0623 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
    }

    /**
     * 체육복 Solution (https://programmers.co.kr/learn/courses/30/lessons/42862)
     *
     * @param n
     * @param lost
     * @param reserve
     * @return
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) list.add(1);
        for (int i = 0; i < lost.length; i++) list.set(lost[i] - 1, list.get(lost[i] - 1) - 1);
        for (int i = 0; i < reserve.length; i++) list.set(reserve[i] - 1, list.get(reserve[i] - 1) + 1);

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (list.get(i) == 2 && list.get(i + 1) == 0) {
                    list.set(i + 1, 1);
                    list.set(i, 1);
                }
            } else if (i == n - 1) {
                if (list.get(i) == 2 && list.get(i - 1) == 0) {
                    list.set(i - 1, 1);
                    list.set(i, 1);
                }
            } else {
                if (list.get(i) == 2) {
                    if (list.get(i - 1) == 0) {
                        list.set(i - 1, 1);
                        list.set(i, 1);
                    } else if (list.get(i + 1) == 0) {
                        list.set(i + 1, 1);
                        list.set(i, 1);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i) > 0) {
                answer++;
            }
        }

        return answer;
    }
}
