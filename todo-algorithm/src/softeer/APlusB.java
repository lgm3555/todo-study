package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB {
    public static void main(String[] args) throws IOException {
        String temp = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((temp = br.readLine().trim()) != null) {
            String[] check = temp.split(" ");
            if (check.length == 2) {
                int A = Integer.parseInt(check[0]);
                int B = Integer.parseInt(check[1]);
                System.out.println("Case #1: " + (A+B));
            }
        }
    }
}
