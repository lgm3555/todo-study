package level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network_0625 {
    ArrayList<Integer> checkList = new ArrayList<>();
    public int answer = 0;
    public static void main(String[] args) {
        Network_0625 network_0625 = new Network_0625();
        System.out.println(network_0625.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    /**
     * 네트워크 Solution (https://programmers.co.kr/learn/courses/30/lessons/43162)
     *
     * @param n
     * @param computers
     * @return
     */
    public int solution(int n, int[][] computers) {
        ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
        Boolean[] visit = new Boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    subList.add(j);
                }
            }
            allList.add(subList);
            checkList.add(i);
            visit[i] = false;
        }

        while (!checkList.isEmpty()) {
            bfs(checkList.get(0), allList, visit);
        }

        return answer;
    }

    public void bfs(int n, ArrayList<ArrayList<Integer>> bfsList, Boolean[] bfsVisit) {
        Queue<Integer> queue = new LinkedList<>();
        bfsVisit[n] = true;
        queue.offer(n);

        while (!queue.isEmpty()) {
            int tempX = queue.poll();
            checkList.remove(Integer.valueOf(tempX));

            for (int i = 0; i < bfsList.get(tempX).size(); i++) {
                int tempY = bfsList.get(tempX).get(i);
                if (!bfsVisit[tempY]) {
                    bfsVisit[tempY] = true;
                    queue.offer(tempY);
                }
            }
        }
        answer++;
    }
}