package level1;

public class CardGroup_230320 {
    public static void main(String[] args) {
        //String[] card1 = {"i", "drink", "water"};
        String[] card1 = {"i", "water", "drink"};
        String[] card2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(card1, card2, goal));
    }


    /**
     * 카드 뭉치 (https://school.programmers.co.kr/learn/courses/30/lessons/159994)
     *
     * @param cards1 첫번째 카드 뭉치
     * @param cards2 두번째 카드 뭉치
     * @param goal 두 카드뭉치의 조합 단어
     * @return
     */
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int a = 0;
        int b = 0;
        for (int i=0; i<goal.length; i++) {
            if (cards1.length > a && cards1[a].equals(goal[i])) {
                a++;
            } else if (cards2.length > b && cards2[b].equals(goal[i])) {
                b++;
            } else {
                return "No";
            }
        }

        return answer;
    }
}
