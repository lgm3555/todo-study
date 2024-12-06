package level2;

import java.util.ArrayList;
public class JoyStick {
    /**
     * 탐욕 알고리즘 level2.Greedy
     * 선택의 순간마다 당장 눈앞에 보이는 최적의 상황만을 쫒아 최종적인 해답에 도달.
     *
     * 탐욕 알고리즘 조건
     * 1. 탐욕스런 선택 조건: 앞의 선택이 이후의 선택에 영향을 주지 않음.
     * 2. 최적 부분 구조 조건: 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성.
     *
     * 문제 해결 방법
     * 1. 선택 절차: 현재 상태에서 최적의 해답을 선택
     * 2. 적절성 검사: 선택된 해가 문제의 조건을 만족하는지 검사
     * 3. 해답 검사: 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가서 위 과정 반복
     *
     * ---
     * 1. 선택 절차
     *  - 위 아래 선택
     *  - 왼쪽 오른쪽 선택
     */
    public static void main(String[] args) {
        int result = solution("JEROEN"); //56
        System.out.println("result = " + result);
    }

    /**
     * 조이스틱 (https://school.programmers.co.kr/learn/courses/30/lessons/42860)
     *  1. 선택 절차: 좌우 가장 적은 수 최적 선택
     *  2. 적절성 검사: 선택된 해가 문제의 조건을 만족하는지 검사
     *  3. 해답 검사: 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가서 위 과정 반복
     * @param name
     * @return
     */
    private static int answer;
    public static int solution(String name) {


        return 0;
    }
}
