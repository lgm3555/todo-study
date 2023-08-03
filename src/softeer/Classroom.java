package softeer;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Classroom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(a, b);
        }

        int result = 0;
        int tempEnd = 0;
        for (Node node : nodes) {
            if (node.start < tempEnd) {
                continue;
            } else {
                result++;
                tempEnd = node.end;
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node node) {
            return this.end - node.end;
        }
    }
}
