package softeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WorldTree_R {
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();;
    private static int[] people;

    /**
     * 축제 (https://softeer.ai/practice/11005)
     *
     * 다익스트라 사용 / 타임아웃, 오답
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/softeer/softeer.txt"));
        int vertex = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i=0; i<=vertex; i++) {
            graph.add(new ArrayList<>());
        }

        people = new int[vertex+1];
        for (int i=0; i<vertex; i++) {
            people[i+1] = Integer.parseInt(input[i]);
        }

        for (int i=0; i<vertex-1; i++) {
            String[] temp = br.readLine().split(" ");
            graph.get(Integer.parseInt(temp[0])).add(new Node(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            graph.get(Integer.parseInt(temp[1])).add(new Node(Integer.parseInt(temp[0]), Integer.parseInt(temp[2])));
        }

        //System.out.println("vertex = " + vertex);
        //System.out.println("people = " + Arrays.toString(people));
        //System.out.println("graph = " + graph);

        int event = Integer.parseInt(br.readLine());
        for (int i=0; i<event; i++) {
            String[] party = br.readLine().split(" ");
            if ("1".equals(party[0])) {
                int partyNum = Integer.parseInt(party[1]);
                //System.out.println("partyNum = " + partyNum);

                int[] dijkstra = dijkstra(partyNum, vertex);
                int sum = 0;
                for (int k=1; k<=vertex; k++) {
                    if (k == partyNum) continue;
                    sum += dijkstra[k] * people[k];
                }

                System.out.println(sum);
            } else {
                people[Integer.parseInt(party[1])] = people[Integer.parseInt(party[1])] + Integer.parseInt(party[2]);
            }
        }
    }

    private static int[] dijkstra(int partyNode, int vertex) {
        int[] distance = new int[vertex + 1];
        boolean[] visited = new boolean[vertex + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pQ = new PriorityQueue<Node>();
        pQ.add(new Node(partyNode, 0));

        distance[partyNode] = 0;

        while (!pQ.isEmpty()) {
            Node poll = pQ.poll();
            int pollIndex = poll.index;
            int pollDistance = poll.distance;

            if (visited[pollIndex]) {
                continue;
            } else {
                visited[pollIndex] = true;
            }

            if (pollDistance > distance[pollIndex]) {
                continue;
            }

            ArrayList<Node> nodes = graph.get(pollIndex);
            for (Node node : nodes) {
                if (distance[node.index] > pollDistance + node.distance) {
                    distance[node.index] = pollDistance + node.distance;
                    pQ.offer(new Node(node.index, distance[node.index]));
                }
            }
        }

        //System.out.println("distance = " + Arrays.toString(distance));

        return distance;
    }

    private static class Node implements Comparable<Node> {
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

        public String toString() {
            return "index = " + index + ", distance = " + distance;
        }
    }
}
