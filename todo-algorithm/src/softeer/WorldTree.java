package softeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldTree {
    private static final ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();;
    private static final ArrayList<Integer> people = new ArrayList<>();

    /**
     * 축제 (https://softeer.ai/practice/11005)
     *
     * dfs, 백트래킹 -> 타임아웃
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/softeer/softeer.txt"));
        int vertex = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        for (int i=0; i<input.length; i++) {
            people.add(Integer.parseInt(input[i]));
        }

        for (int i=0; i<=vertex; i++) {
            graph.add(new HashMap<>());
        }

        for (int i=0; i<vertex-1; i++) {
            String[] distance = br.readLine().split(" ");
            graph.get(Integer.parseInt(distance[0])).put(Integer.parseInt(distance[1]), Integer.parseInt(distance[2]));
            graph.get(Integer.parseInt(distance[1])).put(Integer.parseInt(distance[0]), Integer.parseInt(distance[2]));
        }

        System.out.println("vertex = " + vertex);
        System.out.println("graph = " + graph);
        System.out.println("people = " + people);

        int event = Integer.parseInt(br.readLine());
        for (int i=0; i<event; i++) {
            String[] party = br.readLine().split(" ");
            //System.out.println("party = " + Arrays.toString(party));
            if ("1".equals(party[0])) {
                int answer = 0;
                for (int k=1; k<=vertex; k++) {
                    if (k != Integer.parseInt(party[1])) {
                        boolean[] visit = new boolean[vertex + 1];
                        visit[k] = true;
                        //System.out.println("k = " + k);
                        answer += recursion(k, k, Integer.parseInt(party[1]), visit, 0);
                    }
                }

                System.out.println(answer);
            } else {
                people.set(Integer.parseInt(party[1])-1, people.get(Integer.parseInt(party[1])-1) + Integer.parseInt(party[2]));
            }
        }
    }

    private static int recursion(int start, int now, int target, boolean[] visit, int sum) {
        //System.out.println("now = " + now + ", target = " + target);
        if (now == target) return sum;

        HashMap<Integer, Integer> map = graph.get(now);
        int cnt = people.get(start-1);
        int min = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            if (!visit[key]) {
                visit[key] = true;
                sum += cnt * map.get(key);
                min = Math.min(min, recursion(start, key, target, visit, sum));
                visit[key] = false;
                sum -= cnt * map.get(key);
            }
        }

        return min;
    }
}
/*
6
1 1 1 1 1 1
1 3 1
2 3 10
3 4 100
4 5 1000
4 6 10000
14
1 1
1 2
1 3
1 4
1 5
1 6
2 6 1
2 3 1
1 1
1 2
1 3
1 4
1 5
1 6
*/
