import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_0627 {
    //INF 값 초기화
    static final int INF = Integer.MAX_VALUE;
    //graph 배열
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단거리테이블 배열
    static int[] distance;
    //방문 배열
    static boolean[] visit;

    //간선 설정(양방향)
    public void addEdgeUndirected(int x, int y, int dist) {
        graph.get(x).add(new Node(y, dist));
        graph.get(y).add(new Node(x, dist));
    }

    //간선 설정(단방향)
    public void addEdgeDirected(int x, int y, int dist) {
        graph.get(x).add(new Node(y, dist));
    }

    //우선순위 큐에서 정렬기준을 잡기 위해 Comparable 구현
    static class Node implements Comparable<Node> {
        int index;  //노드 번호
        int distance;   //이동 할 노드까지의 거리

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        //최단거리를 기준으로 오름차순 정렬합니다.
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public void dijkstra(int index) {
        //최단거리가 갱신된 노드들을 담은 우선순위 큐 생성성
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        //최단거리 테이블의 시작지점 노드의 거리 0으로 갱신
        //출발 노드 본인은 거리 0
        distance[index] = 0;
        //출발 노드 우선순위 큐 입력
        pQ.offer(new Node(index, 0));

        while (!pQ.isEmpty()) {
            Node node = pQ.poll();
            int nodeIndex = node.index;
            int dist = node.distance;

            //#1 기존 방식으로 방문여부 체크
            if (visit[nodeIndex]) {
                continue;
            } else {
                visit[nodeIndex] = true;
            }

            //#2 거리로 방문여부 체크
            //큐에서 꺼낸 거리와 최단거리 테이블의 값을 비교해서 방문 처리
            //큐는 최단거리를 기준으로 오름차순 정렬되고 있습니다.
            //만약 현재 꺼낸 노드의 거리가 최단거리 테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드 입니다.
            //그러므로 해당노드와 연결 된 노드를 탐색하지 않고 큐에서 다음 노드를 꺼냅니다.
            if (dist > distance[nodeIndex]) {
                continue;
            }

            //큐에서 꺼낸 노드에서 이동 가능 한 노드들을 탐색합니다.
            for (Node linkedNode : graph.get(nodeIndex)) {
                //해당노드를 거쳐서 다음 노드로 이동 할 때의 값이 다음 이동노드의 최단거리테이블 값보다 작을 때
                if (dist + linkedNode.distance < distance[linkedNode.index]) {
                    //if 조건을 만족했다면 최단거리테이블의 값을 갱신합니다.
                    distance[linkedNode.index] = dist + linkedNode.distance;
                    //갱신 된 노드를 우선순위 큐에 넣어줍니다.
                    pQ.offer(new Node(linkedNode.index, distance[linkedNode.index]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 6;

        //그래프 생성
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }

        //최단거리 테이블 생성
        distance = new int[size + 1];
        //최장거리 설정
        Arrays.fill(distance, INF);

        //방문처리 테이블
        visit = new boolean[size + 1];

        Dijkstra_0627 dijkstra = new Dijkstra_0627();
        //단방향 그래프 생성
        /*
            0 ->
            1 -> Node(index=3, distance=1), Node(index=2, distance=1)
            2 -> Node(index=4, distance=1)
            3 -> Node(index=6, distance=1), Node(index=2, distance=1)
            4 -> Node(index=3, distance=1)
            5 -> Node(index=1, distance=1)
            6 ->
        */
        //양방향 그래프 생성
        /*
            0 ->
            1 -> Node(index=3, distance=1), Node(index=2, distance=1), Node(index=5, distance=1)
            2 -> Node(index=4, distance=1), Node(index=3, distance=1), Node(index=1, distance=1)
            3 -> Node(index=4, distance=1), Node(index=6, distance=1), Node(index=2, distance=1), Node(index=1, distance=1)
            4 -> Node(index=3, distance=1), Node(index=2, distance=1)
            5 -> Node(index=1, distance=1)
            6 -> Node(index=3, distance=1)
        */
        dijkstra.addEdgeUndirected(3, 6, 1);
        dijkstra.addEdgeUndirected(4, 3, 1);
        dijkstra.addEdgeUndirected(3, 2, 1);
        dijkstra.addEdgeUndirected(1, 3, 1);
        dijkstra.addEdgeUndirected(1, 2, 1);
        dijkstra.addEdgeUndirected(2, 4, 1);
        dijkstra.addEdgeUndirected(5, 1, 1);

        //#1출발 노드 설정 : 1
        dijkstra.dijkstra(1);

        System.out.println("Arrays.toString(distance) = " + Arrays.toString(distance));
    }
}
