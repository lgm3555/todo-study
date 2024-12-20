package softeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Intimate {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/softeer/softeer.txt"));
        String[] f = br.readLine().split(" ");
        int total = Integer.parseInt(f[0]);
        int cpti = Integer.parseInt(f[1]);

        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<total; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list);

        System.out.println("list = " + list);

        for (int i=0; i<)
    }
}
