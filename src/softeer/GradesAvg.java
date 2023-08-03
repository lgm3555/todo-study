package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GradesAvg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 줄에서 n과 k를 입력받기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 두 번째 줄에서 숫자들을 입력받아 리스트에 저장
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 세 번째 줄부터 a와 b를 입력받아 평균 계산하여 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = a - 1; j < b; j++) {
                sum += nums[j];
            }

            double average = (double) sum / (b - a + 1);
            sb.append(String.format("%.2f\n", average));
        }

        System.out.print(sb.toString());
    }
}