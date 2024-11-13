package level1;

public class NearNumber {
    public static void main(String[] args) {
        solution("banana ");
    }

    /**
     * 가장 가까운 숫자 (https://school.programmers.co.kr/learn/courses/30/lessons/142086)
     * @param s
     * @return
     */
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i=0; i<s.length(); i++) {
            String subS = s.substring(0, i);
            int a = subS.lastIndexOf(s.charAt(i));
            if (a > -1) {
                a = i - a;
            }
            answer[i] = a;
            //System.out.println("charAt = " + s.charAt(i) + ", subS = " + subS + ", a = " + a + ", i = " + i);
        }

        return answer;
    }
}
