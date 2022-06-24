package level2;

import java.util.ArrayList;
import java.util.Arrays;

public class LifeBoat_0623 {
    public static void main(String[] args) {
        System.out.println(solution1(new int[]{70, 80, 50}, 100));
        //System.out.println(solution1(new int[]{70, 50, 80, 50}, 100));
    }

    public static int solution1(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(people);
        for (int i : people) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            if (list.get(0) > limit) return list.size();

            if (list.get(0) + list.get(list.size() - 1) > limit) {
                list.remove(list.size() - 1);
            } else {
                list.remove(list.size() - 1);
                if (list.size() > 0) list.remove(0);
            }
            answer++;
        }

        return answer;
    }

    /**
     * 구명보트 Solution (https://programmers.co.kr/learn/courses/30/lessons/42885)
     *
     * @param people
     * @param limit
     * @return
     */
    public static int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(people);
        for (int i : people) {
            list.add(i);
        }

        int temp = 0;
        while (!list.isEmpty()) {
            temp = list.get(0);
            list.remove(0);
            answer++;

            for (int j=0; j<list.size(); j++) {
                if (temp + list.get(j) <= limit) {
                    if (j > 1) {
                        break;
                    }
                    temp += list.get(j);
                    list.remove(j);
                }
            }
        }

        return answer;
    }
}
