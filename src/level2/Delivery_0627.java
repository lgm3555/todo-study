package level2;

import java.util.*;

public class Delivery_0627 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));
    }

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] distance;

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static void dijkstra(int index) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();

        distance[index] = 0;

        pQ.offer(new Node(index, 0));

        while (!pQ.isEmpty()) {
            Node node = pQ.poll();
            int nodeIndex = node.index;
            int dist = node.distance;

            if (visit[nodeIndex]) {
                continue;
            } else {
                visit[nodeIndex] = true;
            }

            if (dist > distance[nodeIndex]) {
                continue;
            }

            for (Node linkedNode : graph.get(nodeIndex)) {
                if (dist + linkedNode.distance < distance[linkedNode.index]) {
                    distance[linkedNode.index] = dist + linkedNode.distance;
                    //System.out.println("Arrays.toString(distance) = " + Arrays.toString(distance));
                    pQ.offer(new Node(linkedNode.index, distance[linkedNode.index]));
                }
            }
        }
    }

    /**
     * 배달 Solution (https://programmers.co.kr/learn/courses/30/lessons/12978)
     *
     * @param N
     * @param road
     * @param K
     * @return
     */
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        visit = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i <=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }

        /*for (int i=0; i<road.length; i++) {
            System.out.println(i + "_graph = " + graph.get(i).toString());
        }*/

        dijkstra(1);

        System.out.println(Arrays.toString(distance));

        for (int i=0; i<distance.length; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}
