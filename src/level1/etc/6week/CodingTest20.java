
public class CodingTest20 {
	public static void main(String[] args) {
		solution(5);
	}

	/**
	 * 약수의 합 Solution (https://programmers.co.kr/learn/courses/30/lessons/12928)
	 * 
	 * @param n 정수
	 * @return n의 약수의 합
	 */
	public static int solution(int n) {
		int answer = 0;
		
		for (int i=1; i<=n; i++) {
			if (n % i == 0) {
				answer = answer + i;
			}
		}

		return answer;
	}
}
