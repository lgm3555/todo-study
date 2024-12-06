package dfs_bfs;

import java.util.ArrayList;
import java.util.Stack;

public class Network_0625 {
    public static void main(String[] args) {
        //System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    /**
     * 네트워크 Solution (https://programmers.co.kr/learn/courses/30/lessons/43162)
     *
     * @param n
     * @param computers
     * @return
     */
    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visit;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for (int i=0; i<computers.length; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int j=0; j<n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    tempList.add(j);
                }
                visit[j] = false;
            }
            graph.add(tempList);
        }

        //System.out.println("graph = " + graph);

        for (int i=0; i<n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            visit[pop] = true;
            ArrayList<Integer> list = graph.get(pop);
            for (int l : list) {
                if (visit[l]) {
                    continue;
                }

                stack.push(l);
            }
        }
    }
}