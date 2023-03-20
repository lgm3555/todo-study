package level3;

import java.util.ArrayList;

public class Rank {
    public static void main(String[] args) {
        solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/49191
     *
     * @param n
     * @param results
     * @return
     */
    public static int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<results.length; i++) {
            graph.get(results[i][0]).add(results[i][1]);
        }

        System.out.println("graph = " + graph);

        return answer;
    }
}
