import java.util.*;

public class GraphBfs_0626 {
    private static final int n = 8;    // node 수
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;

    public static void main(String[] args) {
        GraphBfs_0626 graphBfs = new GraphBfs_0626();
        graphBfs.setGraph();
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " -> " + graph.get(i));
        }
        System.out.println();

        System.out.print("bfs: ");
        visit = new boolean[n];
        graphBfs.bfs(0);
    }

    // 너비우선탐색
    public void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        visit[startNode] = true;
        q.offer(startNode);

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visit[y]) {
                    visit[y] = true;
                    q.offer(y);
                }
            }
        }
    }

    // 그래프 세팅
    public void setGraph() {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // node=0
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(7);

        // node=1
        graph.get(1).add(0);
        graph.get(1).add(6);

        // node=2
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(2).add(4);

        // node=3
        graph.get(3).add(2);
        graph.get(3).add(4);

        // node=4
        graph.get(4).add(2);
        graph.get(4).add(3);

        // node=5
        graph.get(5).add(6);

        // node=6
        graph.get(6).add(1);
        graph.get(6).add(5);
        graph.get(6).add(7);

        // node=7
        graph.get(7).add(0);
        graph.get(7).add(6);
    }
}