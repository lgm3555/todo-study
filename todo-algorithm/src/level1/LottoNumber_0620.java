package level1;

import java.util.Arrays;

public class LottoNumber_0620 {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    /**
     * 로또의 최고 순위와 최저 순위 Solution (https://programmers.co.kr/learn/courses/30/lessons/77484)
     *
     * @param lottos 로또 번호
     * @param win_nums 당첨 번호
     * @return
     */
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int check = 0;
        int zero = 0;

        for (int l : lottos) {
            if (l == 0) {
                zero++;
                continue;
            }

            for (int i=0; i<win_nums.length; i++) {
                if (l == win_nums[i]) {
                    check++;
                    break;
                }
            }
        }

        System.out.println(check);

        answer[0] = (check + zero == 6) ? 1 : (check + zero == 5) ? 2 : (check + zero == 4) ? 3 : (check + zero == 3) ? 4 : (check + zero == 2) ? 5 : 6;
        answer[1] = (check == 6) ? 1 : (check == 5) ? 2 : (check == 4) ? 3 : (check == 3) ? 4 : (check == 2) ? 5 : 6;

        return answer;
    }
}
