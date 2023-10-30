package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MapAutoBuild {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int squars = 1;
        for (int i=1; i<=n; i++) {
            squars *= 4;
        }

        double line = Math.sqrt(squars);
        int result = (int) ((line+1) * (line+1));

        System.out.println(result);
    }
}
