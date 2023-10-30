package dfs_bfs;

import java.util.ArrayList;
import java.util.Stack;

public class Network {

    public static void main(String[] args) {
        Network network = new Network();
        System.out.println(network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    /**
     * 네트워크 Solution (https://programmers.co.kr/learn/courses/30/lessons/43162)
     *
     * @param n
     * @param computers
     * @return
     */
    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private Boolean[] flag;
    private int result = 0;
    public int solution(int n, int[][] computers) {

        flag = new Boolean[n];

        for (int i=0; i<computers.length; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j=0; j<n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    subList.add(j);
                }
            }
            list.add(subList);
            flag[i] = false;
        }

        dfs(0);

        return result;
    }

    private void dfs(int target) {
        Stack<Integer> stack = new Stack<>();
        stack.push(target);
        flag[target] = true;
        result++;

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            ArrayList<Integer> subList = list.get(pop);

            for (int i=0; i<subList.size(); i++) {
                if (!flag[subList.get(i)]) {
                    stack.push(subList.get(i));
                    flag[subList.get(i)] = true;
                }
            }
        }

        for (int i=0; i<flag.length; i++) {
            if (!flag[i]) {
                dfs(i);
            }
        }
    }
}
