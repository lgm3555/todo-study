package level0;

public class OblongExtent {
    public static void main(String[] args) {
        solution(new int[][] {{1, 1}, {2, 1}, {2, 2}, {1, 2}});
    }

    /**
     * 직사각형 넓이 구하기 (https://school.programmers.co.kr/learn/courses/30/lessons/120860)
     *
     * @param dots
     * @return
     */
    public static int solution(int[][] dots) {
        int x = dots[0][0];
        int y = dots[0][1];
        int x1 = 0;
        int y1 = 0;

        for (int i=1; i<dots.length; i++) {
            if (x == dots[i][0]) {
                y1 = dots[i][1];
            }

            if (y == dots[i][1]) {
                x1 = dots[i][0];
            }
        }

        return (x - x1) * (y - y1) > 0 ? (x - x1) * (y - y1) : (x - x1) * (y - y1) * -1;
    }
}
