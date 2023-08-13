package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class WorkRoad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        int n = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int m = Integer.parseInt(st.nextToken());

        Boolean[] flagIn = new Boolean[n + 1];
        Boolean[] flagOut = new Boolean[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            flagIn[i] = false;
            flagOut[i] = false;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int workIn = Integer.parseInt(st.nextToken());
        int workOut = Integer.parseInt(st.nextToken());

        dfs(workIn, workOut, flagIn, graph);
        dfs(workOut, workIn, flagOut, graph);

        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (i != workIn && i != workOut) {
                if (flagIn[i] && flagOut[i]) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int start, int finish, Boolean[] flag, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        flag[start] = true;

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (now == finish) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                if (!flag[graph.get(now).get(i)]) {
                    flag[graph.get(now).get(i)] = true;
                    stack.push(graph.get(now).get(i));
                }
            }
        }
    }
}