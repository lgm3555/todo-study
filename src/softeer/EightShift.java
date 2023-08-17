package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EightShift {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int check = 0;
        for (int i=1; i<8; i++) {
            int y = Integer.parseInt(st.nextToken());
            if (x == 8) {
                if (x - i == y) {
                    check = 1;
                } else {
                    check = 0;
                    break;
                }
            } else if (x == 1) {
                if (x + i == y) {
                    check = 2;
                } else {
                    check = 0;
                    break;
                }
            } else {
                check = 0;
                break;
            }
        }

        if (check == 1) {
            System.out.println("descending");
        } else if (check == 2) {
            System.out.println("ascending");
        } else {
            System.out.println("mixed");
        }
    }
}