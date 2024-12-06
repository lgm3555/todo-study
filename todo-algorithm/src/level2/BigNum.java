package level2;

/**
 * 그리디 문제 해결 방법
 * 1. 선택 절차: 현재 상태에서 최적의 해답을 선택
 * 2. 적절성 검사: 선택된 해가 문제의 조건을 만족하는지 검사
 * 3. 해답 검사: 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가서 위 과정 반복
 *
 * Greedy는 부분 문제의 최적 결과 값이 전체의 최적 결과 값과 일치해야 사용 가능.
 */
public class BigNum {
    public static void main(String[] args) {
        solution("1231234", 3); //3234
        /*
            (7) - (4-1) = 3 + start = 3
            (7 - 3) - (3-1) = 2 + start = 5
            (7 - 5) - (2-1) = 1 + start = 6
            (7 - 6) - (1-1) = 1 + start = 7

            start = 0, end = 3, safe = 4
            result = 3, index = 2
            start = 3, end = 5, safe = 3
            result = 2, index = 4
            start = 5, end = 6, safe = 2
            result = 3, index = 5
            start = 6, end = 7, safe = 1
            result = 4, index = 6
        */
    }

    /**
     * 큰 수 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/42883)
     *
     * 그리디 문제 해결 방법
     * 1. 선택 절차: 현재 상태에서 최적의 해답을 선택
     * 2. 적절성 검사: 선택된 해가 문제의 조건을 만족하는지 검사
     * 3. 해답 검사: 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가서 위 과정 반복
     */
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int safe = number.length() - k;
        int start = 0;
        int end = (number.length()) - (safe - 1);
        int max = 0;
        int index = 0;
        for (int i=0; i<number.length()-k; i++) {
            //System.out.println("start = " + start + ", end = " + end + ", safe = " + safe + ", k = " + k);
            if (start == number.length()) break;
            if (start + safe == number.length() || k==0) {
                answer.append(number, start, number.length());
                break;
            }
            max = Integer.parseInt(String.valueOf(number.charAt(start)));
            index = start;
            for (int j=start; j<end; j++) {
                int i1 = Integer.parseInt(String.valueOf(number.charAt(j)));
                if (i1 > max) {
                    max = i1;
                    index = j;
                }
                if (max == 9) break;
            }

            //System.out.println("result = " + max + ", index = " + index);
            answer.append(max);
            k = k-(index-start);
            start = index+1;
            safe--;
            end = (number.length() - start) - (safe-1) + start;
            if (safe == 0) break;
        }

        //System.out.println("answer = " + answer.toString());

        return answer.toString();
    }
}