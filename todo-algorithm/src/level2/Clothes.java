package level2;

import java.util.HashMap;

public class Clothes {
    public static void main(String[] args) {
        solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    /**
     * 의상 (https://school.programmers.co.kr/learn/courses/30/lessons/42578)
     *
     * @param clothes
     * @return
     */
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], (map.getOrDefault(clothes[i][1], 0)) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;

        }

        return answer -1;
    }
}
