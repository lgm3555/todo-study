package level3;

import java.util.*;

/**
 * 크루스칼 알고리즘
 * 1. 간선 정렬 = 비용 기준으로 오름차순 정렬
 * 2. Union Find = 서로 다른 집합을 합치기 위해 Union-Find 사용
 * 3. 간선 선택 = 비용이 가장 적은 간선부터 선택하여 사이클이 생기지 않으면 추가.
 */
public class IslandConnect {
    public static void main(String[] args) {
        solution(4, new int[][] {{0,1,1},{1,3,1},{0,2,2},{1,2,5},{2,3,8}});
        //solution(5, new int[][] {{0,1,10},{0,1,12},{0,1,5},{0,1,1},{0,1,8}});
    }

    /**
     * 섬 연결하기 (https://school.programmers.co.kr/learn/courses/30/lessons/42861)
     *
     * @param n
     * @param costs
     * @return
     */
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] fromIsland = new int[n];

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        //System.out.println("costs = " + Arrays.deepToString(costs));

        for (int i=0; i<n; i++) {
            fromIsland[i] = i;
        }

        for(int[] cost : costs){
            //System.out.println("fromIsland = " + Arrays.toString(fromIsland));
            int rootA = check(cost[0], fromIsland);
            int rootB = check(cost[1], fromIsland);
            if (rootA != rootB) {
                if (rootA > rootB) {
                    fromIsland[rootA] = rootB;
                } else {
                    fromIsland[rootB] = rootA;
                }
                answer += cost[2];
            }
        }

        //System.out.println("answer = " + answer);

        return answer;
    }

    private static int check(int node, int[] fromIsland) {
        if (fromIsland[node] == node) {
            return node;
        }
        return check(fromIsland[node], fromIsland);
    }
}