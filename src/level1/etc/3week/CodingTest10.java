import java.util.Stack;

public class CodingTest10 {
	public static void main(String[] args) {
		solution(3, 5);
	}

	/**
	 * 두 정수 사이의 합 Solution (https://programmers.co.kr/learn/courses/30/lessons/12912)
	 * 
	 * @param a 정수
	 * @param b 정수
	 * @return 두 정수 숫자 사이의 합
	 */
	public static long solution(int a, int b) {
		long answer = 0;

		if (a > b) {
			while (true) {
				answer = answer + b;
				if (a == b) {
					break;
				}

				b++;
			}
		} else if (a < b) {
			while (true) {
				answer = answer + a;
				if (a == b) {
					break;
				}

				a++;
			}
		} else {
			answer = a;
		}

		return answer;
	}
}
