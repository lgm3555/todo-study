package level1;

public class PaintOver_230328 {
    public static void main(String[] args) {
        // 2
        //solution(8, 4, new int[]{2, 4, 6});
        // 1
        //solution(5, 4, new int[]{1, 3});
        // 4
        //solution(4, 1, new int[]{1, 2, 3, 4});
        // 3
        solution(20, 4, new int[]{1, 7, 10, 19, 20});
    }

    /**
     * 덧칠하기 (https://school.programmers.co.kr/learn/courses/30/lessons/161989)
     * 
     * @param n 벽의 길이
     * @param m 롤러의 길의
     * @param section 덧칠해야 할 벽 번호
     * @return
     */
    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int temp = (section[0] + m) - 1;

        for (int i=1; i<section.length; i++) {
            if (temp >= section[i]) {
                continue;
            } else {
                temp = (section[i] + m) - 1;
                answer++;
            }
        }

        return answer;
    }
}
