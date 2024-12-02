package level2;

import java.util.*;
import java.util.stream.Collectors;

public class UninhabitedIslandTravel {
    public static void main(String[] args) {
        solution(new String[] {"X591X","X1X5X","X231X", "1XXX1"}); //[1, 1, 27]
    }

    private static int[][] graph;
    private static final Stack<int[]> stack = new Stack<>();

    /**
     * 무인도 여행 (https://school.programmers.co.kr/learn/courses/30/lessons/154540)
     *
     * @param maps
     * @return
     */
    public static int[] solution(String[] maps) {
        int row = maps[0].length(); //행
        int line = maps.length; //열

        System.out.println("line = " + line + ", row = " + row);
        graph = new int[line][row];

        // 그래프 초기화
        for (int i=0; i<line; i++) {
            char[] charArray = maps[i].toCharArray();
            for (int j=0; j<charArray.length; j++) {
                String s = String.valueOf(charArray[j]);
                if ("X".equals(s)) {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = Integer.parseInt(s);
                }
            }
        }

        //List<List<Integer>> graphList = Arrays.stream(graph).map(rows -> Arrays.stream(rows).boxed().collect(Collectors.toList())).toList();
        //System.out.println("graph = " + graphList);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<line; i++) {
            for (int j=0; j<row; j++) {
                if (graph[i][j] != -1) {
                    list.add(check(new int[]{i, j}, line, row));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[] {-1};
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static int check(int[] start, int line, int row) {
        int answer = 0;
        stack.push(start);
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            if (graph[pop[0]][pop[1]] == -1) continue;
            answer += graph[pop[0]][pop[1]];
            graph[pop[0]][pop[1]] = -1;

            //방향
            if (pop[0] + 1 >= 0 && pop[1] >= 0 && pop[0] + 1 < line && pop[1] < row && graph[pop[0] + 1][pop[1]] != -1) {
                stack.push(new int[] {pop[0] + 1, pop[1]});
            }
            if (pop[0] - 1 >= 0 && pop[1] >= 0 && pop[0] - 1 < line && pop[1] < row && graph[pop[0] - 1][pop[1]] != -1) {
                stack.push(new int[] {pop[0] - 1, pop[1]});
            }
            if (pop[0] >= 0 && pop[1] + 1 >= 0 && pop[0] < line && pop[1] + 1 < row && graph[pop[0]][pop[1] + 1] != -1) {
                stack.push(new int[] {pop[0], pop[1] + 1});
            }
            if (pop[0] >= 0 && pop[1] - 1 >= 0 && pop[0] < line && pop[1] - 1 < row && graph[pop[0]][pop[1] - 1] != -1) {
                stack.push(new int[] {pop[0], pop[1] - 1});
            }
        }
        return answer;
    }
}
