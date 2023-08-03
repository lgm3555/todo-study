package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FrogInWell {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> w = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            w.add(Integer.parseInt(st.nextToken()));
        }

        Boolean[] flag = new Boolean[n];
        for (int i=0; i<n; i++) {
            flag[i] = true;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (w.get(a-1) > w.get(b-1)) {
                flag[b-1] = false;
            } else if (w.get(a-1) < w.get(b-1)) {
                flag[a-1] = false;
            } else {
                flag[a-1] = false;
                flag[b-1] = false;
            }
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            if (flag[i]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
