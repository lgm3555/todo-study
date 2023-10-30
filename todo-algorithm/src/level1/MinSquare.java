package level1;

public class MinSquare {
    public static void main(String[] args) {
        MinSquare minSquare = new MinSquare();
        minSquare.solution(new int[][] {{60,50},{30,70},{60,30},{80,40}});
    }

    /**
     * 최소직사각형형 (https://school.programmers.co.kr/learn/courses/30/lessons/86491)
     *
     * @param sizes
     * @return
     */
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for (int i=0; i<sizes.length; i++) {
            int newX = Math.max(sizes[i][0], sizes[i][1]);
            int newY = Math.min(sizes[i][0], sizes[i][1]);

            if (newX > maxX) {
                maxX = newX;
            }
            if (newY > maxY) {
                maxY = newY;
            }
        }

        return maxX * maxY;
    }
}
