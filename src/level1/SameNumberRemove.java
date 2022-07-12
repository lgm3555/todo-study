package level1;

import java.util.ArrayList;

public class SameNumberRemove {
    public static void main(String[] args) {
        solution(new int[] {4,4,4,3,3});
    }

    /**
     * 같은 숫자는 싫어 Solution (https://school.programmers.co.kr/learn/courses/30/lessons/12906)
     *
     * @param arr
     * @return
     */
    public static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i=1; i<arr.length; i++) {
            if (arr[i-1] != arr[i]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
