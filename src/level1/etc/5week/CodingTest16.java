
public class CodingTest16 {
	public static void main(String[] args) {
		solution(10);
	}

	/**
	 * 소수 찾기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12921)
	 * 
	 * @param n 자연수
	 * @return 소수 개수
	 */
	public static int solution(int n) {
		int answer = 0;

		for (int i = 2; i <= n; i++) {

			int cnt = 0;

			for (int j = 2; j < i; j++) {
				if (i % j == 0 || i == 2) {
					cnt++;
					break;
				}
			}

			if (cnt == 0) {
				answer++;
			}

		}

		return answer;
	}
}
