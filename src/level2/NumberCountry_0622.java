package level2;

import java.util.HashMap;
import java.util.Stack;

public class NumberCountry_0622 {


    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
    }

    /**
     * 프린터 Solution (https://programmers.co.kr/learn/courses/30/lessons/42587)
     *
     * @param priorities 우선순위
     * @param location 요청한 문서 순위
     * @return
     */
    public static int solution(int[] priorities, int location) {
        int answer = priorities[location];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<priorities.length; i++) {
            
        }

        return answer;
    }
}
