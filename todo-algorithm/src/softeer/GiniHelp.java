package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TODO 못풀음.
public class GiniHelp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Boolean[][] flag = new Boolean[r+1][c+1];
        Node start = null;
        Node finish = null;
        ArrayList<Node> rain = new ArrayList<>();
        for (int i=1; i<=r; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j=1; j<=c; j++) {
                Character x = temp.charAt(j-1);

                if (x.equals('H')) {
                    finish = new Node(i, j, "H");
                    flag[i][j] = true;
                } else if (x.equals('W')) {
                    start = new Node(i, j, "W");
                    flag[i][j] = true;
                } else if (x.equals('X')) {
                    flag[i][j] = true;
                } else if (x.equals('*')) {
                    flag[i][j] = true;
                    rain.add(new Node(i, j, "*"));
                } else {
                    flag[i][j] = false;
                }
            }
        }

        System.out.println(start.x + "---" + start.y);
        System.out.println(finish.x + "---" + finish.y);

        int result = bfs(r, c, start, finish, rain, flag);
        System.out.println(result == 0 ? "FAIL" : result);
    }

    private static int bfs(int r, int c, Node start, Node finish, ArrayList<Node> rain, Boolean[][] flag) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        flag[start.x][start.y] = true;

        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Node pop = queue.poll();

            answer += 1;
            if (finish.x == pop.x && finish.y == pop.y) return answer;

            for (int[] direct : direction) {
                int newX = pop.x - direct[0];
                int newY = pop.y - direct[1];

                if (newX > 0 && newY > 0 && newX <= c && newY <= r) {
                    if (!flag[newX][newY]) {
                        queue.offer(new Node(newX, newY, ""));
                    }
                }
            }

            int size = rain.size();
            for (int i=0; i<size; i++) {
                for (int[] direct : direction) {
                    int rainX = rain.get(i).x - direct[0];
                    int rainY = rain.get(i).y - direct[1];

                    if (rainX > 0 && rainY > 0 && rainX <= c && rainY <= r) {
                        if (!flag[rainX][rainY]) {
                            flag[rainX][rainY] = true;
                            rain.add(new Node(rainX, rainY, "*"));
                        }
                    }
                }
                rain.remove(i);
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;
        String t;
        public Node(int x, int y, String t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
