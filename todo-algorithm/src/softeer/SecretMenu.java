package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretMenu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mnk = br.readLine().split(" ");
        String m = br.readLine().replace(" ", "");
        String n = br.readLine().replace(" ", "");

        if (n.contains(m)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}