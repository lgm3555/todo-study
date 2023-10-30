package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrivieDistance {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);

        if (a == b) {
            System.out.println("same");
        } else if (a > b) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }

}
