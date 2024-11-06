package level0;

public class OxQuiz {
    public static void main(String[] args) {
        solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"});
    }

    /**
     * OX 퀴즈 (https://school.programmers.co.kr/learn/courses/30/lessons/120907)
     *
     * @param quiz
     * @return
     */
    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i=0; i<quiz.length; i++) {
            String[] sub = quiz[i].split(" ");

            int a = Integer.parseInt(sub[0]);
            int b = Integer.parseInt(sub[2]);
            int c = Integer.parseInt(sub[4]);

            switch (sub[1]) {
                case "+":
                    answer[i] = a + b == c ? "O" : "X";
                    break;
                case "-":
                    answer[i] = a - b == c ? "O" : "X";
                    break;
                case "*":
                    answer[i] = a * b == c ? "O" : "X";
                    break;
                case "/":
                    answer[i] = a / b == c ? "O" : "X";
                    break;
            }
        }

        return answer;
    }
}
