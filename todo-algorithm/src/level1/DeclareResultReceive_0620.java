package level1;

import java.util.*;

public class DeclareResultReceive_0620 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    /**
     * 신고 결과 받기 Solution (https://programmers.co.kr/learn/courses/30/lessons/92334)
     *
     * @param id_list 유저 ID 리스트
     * @param report 유저가 신고항 ID 리스트
     * @param k 정지 기준
     * @return
     */
    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>(); //신고당한 횟수
        HashMap<String, Integer> linkedMap = new LinkedHashMap<>();

        for (int i=0; i<id_list.length; i++) {
            linkedMap.put(id_list[i], 0);
        }

        Arrays.sort(report);
        String temp = "";
        for (String s : report) {
            if (temp.equals(s)) continue;
            temp = s;

            String[] arr = s.split(" ");
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        temp = "";
        for (String s : report) {
            if (temp.equals(s)) continue;
            temp = s;

            String[] arr = s.split(" ");
            if (map.get(arr[1]) >= k) {
                linkedMap.put(arr[0], linkedMap.getOrDefault(arr[0], 0) + 1);
            }
        }

        return linkedMap.entrySet().stream().mapToInt(value -> value.getValue()).toArray();
    }
}
