package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuperVirus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        long result = repeat(p, n*10);
        result = result * k;
        System.out.println(result % 1000000007);
    }

    private static long repeat(long a, long b) {
        long temp = 0;

        if (b == 1) {
            return a;
        } else if (b % 2 == 0) {
            temp = repeat(a, b / 2);
            return temp * temp % 1000000007;
        } else {
            temp = repeat(a, b / 2);
            return (temp * temp % 1000000007) * a % 1000000007;
        }
    }
}
