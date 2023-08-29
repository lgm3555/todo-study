package level2;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeToCar {
    public static void main(String[] args) {
        BridgeToCar bridgeToCar = new BridgeToCar();
        //bridgeToCar.solution(2, 10, new int[]{7,4,5,6});
        bridgeToCar.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
    }

    /**
     * 다리를 지나는 트럭 (https://school.programmers.co.kr/learn/courses/30/lessons/42583)
     *
     * @param bridge_length
     * @param weight
     * @param truck_weights
     * @return
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(truck_weights[0], 0));

        int sum = truck_weights[0];
        int cnt = 1;
        int i = 1;
        while (!queue.isEmpty()) {
            Node peek = queue.peek();
            if (peek.bridge + bridge_length == cnt) {
                Node poll = queue.poll();
                //System.out.println("cnt = " + cnt);
                //System.out.println("poll = " + poll.weight + "--" + poll.bridge);
                sum = sum - poll.weight;
            }

            cnt++;
            if (i == truck_weights.length) continue;

            int temp = sum + truck_weights[i];
            if (temp <= weight) {
                queue.add(new Node(truck_weights[i], cnt-1));
                //System.out.println("queue = " + truck_weights[i] + "-" + (cnt-1));
                sum += truck_weights[i];
                i++;
            }
        }

        //System.out.println("cnt = " + cnt);
        
        return cnt;
    }

    private class Node {
        int weight;
        int bridge;

        public Node(int weight, int bridge) {
            this.weight = weight;
            this.bridge = bridge;
        }
    }
}
