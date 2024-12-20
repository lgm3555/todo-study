import java.util.HashMap;

/**
 * DP (동적 프로그래밍)
 * 큰 문제를 작은 문제로 나누고, 중복되는 계산 결과를 저장해 최적의 해를 찾는 방법
 * .
 */
public class Dp {
    public static void main(String[] args) {
        int i = dp_1(10);
        //int j = dp_2(10);
    }

    public static int dp_1(int n) {
        if (n <= 1) return n;  // F(0) = 0, F(1) = 1

        int[] dp = new int[n + 1]; // 결과 저장 배열
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 작은 문제의 결과를 재사용
        }

        //System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        
        return dp[n];
    }

    private static final HashMap<Integer, Integer> memo = new HashMap<>();
    public static int dp_2(int n) {
        if (n <= 1) return n; // F(0) = 0, F(1) = 1

        if (!memo.containsKey(n)) { // 아직 계산하지 않은 값이라면 계산
            memo.put(n, dp_2(n - 1) + dp_2(n - 2));
        }

        return memo.get(n); // 저장된 결과 사용
    }
}
