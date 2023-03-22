package level1;

public class SmallSubString_230322 {
    public static void main(String[] args) {
        solution("500220839878", "7");
    }

    /**
     * 크기가 작은 부분 문자열 (https://school.programmers.co.kr/learn/courses/30/lessons/147355)
     *
     * @param t 긴 문자열
     * @param p 비교 문자열
     * @return
     */
    public static int solution(String t, String p) {
        int answer = 0;
        int sum = p.length();

        for (int i=0; i<t.length(); i++) {
            if (t.length() >= sum + i) {
                if (Long.parseLong(p) >= Long.parseLong(t.substring(i, sum + i))) {
                    answer++;
                }
            }
        }

        return answer;
    }
}