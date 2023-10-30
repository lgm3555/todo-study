package level1;

public class FoodFight_230328 {
    public static void main(String[] args) {
        //1223330333221
        solution(new int[]{1, 3, 4, 6});

        //111303111
        solution(new int[]{1, 7, 1, 2});
    }

    /**
     * 푸드 파이터 대회 (https://school.programmers.co.kr/learn/courses/30/lessons/134240)
     *
     * @param food
     * @return
     */
    public static String solution(int[] food) {
        String answer = "";

        for (int i=1; i<food.length; i++) {
            for (int j=0; j<(food[i] / 2); j++) {
                answer = answer + i;
            }
        }

        String temp = "";

        for (int i=answer.length()-1; i>=0; i--) {
            temp = temp + answer.split("")[i];
        }

        answer = answer + "0" + temp;
        
        return answer;
    }
}
