package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StoneBridge {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            resultList.add(1);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (list.get(i) > list.get(j)) {
                    resultList.set(i, Math.max(resultList.get(i), resultList.get(j) + 1));
                }
            }
        }

        int result = 1;
        for (int i=0; i<resultList.size(); i++) {
            if (result < resultList.get(i)) {
                result = resultList.get(i);
            }
        }

        System.out.println(result);
    }
}
