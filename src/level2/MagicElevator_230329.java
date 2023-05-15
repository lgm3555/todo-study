package level2;

public class MagicElevator_230329 {
    public static void main(String[] args) {
        // 6
        solution(16);
        // 11
        // 7 = 678 - 700 = -22
        // 2 = 300 - 322 = -2
        // 2 = 20 - 22 = 0
        //solution(678);
        // 16
        // 3 = 3000 - 2554 = 446
        // 4 = 446 - 400 = 46
        // 5 = 50 - 46 = 4
        // 4 = 4 -4 = 0

        // 16
        // 2 = 2554 - 2000 = 554
        // 5 = 554 - 500 = 54
        // 5 = 54 - 50 = 4
        // 4 = 4 -4 = 0
        //solution(2554);
        // 8
        // 1 = 678 - 1000 = -322
        // 3 = 300 - 322 = -22
        // 2 = 20 - 22 = -2
        // 2 = 2 - 2 = 0
        // 2
        //solution(999);

        // 1자리 6이상
        // 2자리 6이상
    }

   /**
     * 마법의 엘레베이터 (https://school.programmers.co.kr/learn/courses/30/lessons/148653)
     *
     * @param storey
     * @return
     */
    public static int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int temp = storey % 10;

            if (temp > 5) {
                storey = storey + (10 - temp);
                answer = answer + (10 - temp);
            } else if (temp == 5 && (storey / 10) % 10 >= 5) {
                storey = storey + (10 - temp);
                answer = answer + (10 - temp);
            } else {
                answer = answer + temp;
            }
            storey = storey / 10;
        }

        return answer;
    }
}
