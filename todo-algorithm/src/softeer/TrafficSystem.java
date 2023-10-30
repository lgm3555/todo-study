package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TrafficSystem {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<int[][]> standard = new ArrayList<>();
        standard.add(new int[][]{{1, 0}, {1, 1}, {1, -1}});
        standard.add(new int[][]{{0, 1}, {1, 1}, {-1, 1}});
        standard.add(new int[][]{{-1, 0}, {-1, 1}, {-1, -1}});
        standard.add(new int[][]{{0, -1}, {1, -1}, {-1, -1}});

        standard.add(new int[][]{{1, 0}, {1, 1}});
        standard.add(new int[][]{{0, 1}, {-1, 1}});
        standard.add(new int[][]{{-1, 0}, {-1, -1}});
        standard.add(new int[][]{{0, -1}, {1, -1}});

        standard.add(new int[][]{{1, 0}, {1, -1}});
        standard.add(new int[][]{{0, 1}, {1, 1}});
        standard.add(new int[][]{{-1, 0}, {-1, 1}});
        standard.add(new int[][]{{0, -1}, {-1, -1}});

        System.out.println("standard = " + standard);

        ArrayList<ArrayList<Integer>> signal = new ArrayList<>();
        for (int i=0; i<N; i++) {
            ArrayList<Integer> signalList = new ArrayList<>();
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                signalList.add(Integer.parseInt(st.nextToken()));
                signalList.add(Integer.parseInt(st.nextToken()));
                signalList.add(Integer.parseInt(st.nextToken()));
                signalList.add(Integer.parseInt(st.nextToken()));
            }
            signal.add(signalList);
        }

        Boolean[][] flag = new Boolean[N][N];

        bfs(N, T, flag, standard, signal);

    }

    private static void bfs(int N, int T, Boolean[][] flag, ArrayList<int[][]> standard, ArrayList<ArrayList<Integer>> signal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            flag[x][y] = true;

            Integer signalNow = signal.get(distance).get(distance % 4);
            int[][] standardNow = standard.get(signalNow);
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N ) {
                    queue.offer(new int[]{newX, newY, distance + 1});
                    flag[newX][newY] = true;
                }
            }

            if (distance == T) {
                break;
            }
        }
    }
}