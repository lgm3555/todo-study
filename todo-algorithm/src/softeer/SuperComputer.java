package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SuperComputer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        long left = list.get(0);
        long right = list.get(n-1) + (long)Math.sqrt(b);
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(mid, b, list)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(double mid, double b, ArrayList<Integer> list) {
        long cost = 0;
        for (int i : list) {
            if (i < mid) {
                cost += (mid - i) * (mid - i);
                if (cost > b) {
                    return false;
                }
            }
        }

        return true;
    }
}