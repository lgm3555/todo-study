package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TODO 못풀음. 효율성 + 오답
public class DistanceSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<Node>());
        }

        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list.get(x).add(new Node(x, y, t));
            list.get(y).add(new Node(y, x, t));
        }

        for (int i=1; i<n+1; i++) {
            System.out.println(dfs(n, list, i));
        }
    }

    private static int dfs(int n, ArrayList<ArrayList<Node>> list, int pwd) {
        Boolean[] flag = new Boolean[n+1];
        for (int i=0; i<=n; i++) {
            flag[i] = false;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {pwd, 0});
        flag[pwd] = true;

        int result = 0;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();

            for (int i=0; i<list.get(pop[0]).size(); i++) {
                Node node = list.get(pop[0]).get(i);

                int y = node.y;
                if (!flag[y]) {
                    flag[y] = true;
                    stack.push(new int[] {y, pop[1] + node.t});
                    result += pop[1] + node.t;
                }
            }
        }

        return result;
    }

    static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}