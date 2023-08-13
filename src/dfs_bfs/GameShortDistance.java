package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameShortDistance {
    public static void main(String[] args) {
        GameShortDistance gameShortDistance = new GameShortDistance();
        // 11
        int result = gameShortDistance.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        System.out.println("result = " + result);
        // -1
        //int result = gameShortDistance.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});
        //System.out.println("result = " + result);
    }

    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 시작점을 큐에 추가

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == m - 1 && y == n - 1) {
                return distance; // 목적지에 도달한 경우 거리 반환
            }

            visited[x][y] = true;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                        maps[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, distance + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; // 목적지에 도달하지 못한 경우 -1 반환
    }

    public int solution_t(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int distance = temp[2] + 1;

            maps[temp[0]][temp[1]] = 0;

            System.out.println(temp[0] + "--" + temp[1]);

            if (temp[0] == m-1 && temp[1] == m-1) {
                return distance;
            }

            if (temp[0] + 1 < m && maps[temp[0] + 1][temp[1]] == 1) {
                queue.offer(new int[]{temp[0] + 1, temp[1], distance});
            }

            if (temp[0] - 1 >= 0 && maps[temp[0] - 1][temp[1]] == 1) {
                queue.offer(new int[]{temp[0] - 1, temp[1], distance});
            }

            if (temp[1] + 1 < n && maps[temp[0]][temp[1] + 1] == 1) {
                queue.offer(new int[]{temp[0], temp[1] + 1, distance});
            }

            if (temp[1] - 1 >= 0 && maps[temp[0]][temp[1] - 1] == 1) {
                queue.offer(new int[]{temp[0], temp[1] - 1, distance});
            }
        }

        return -1;
    }
}
