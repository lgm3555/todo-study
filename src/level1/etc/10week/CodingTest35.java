
public class CodingTest35 {
	public static void main(String[] args) {
		solution(2, 5);
	}

	/**
	 * x만큼 가격이 있는 n개의 숫자 Solution (https://programmers.co.kr/learn/courses/30/lessons/12954)
	 * 
	 * @param x 정수
	 * @param n 자연수
	 * @return x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트
	 */
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		long temp = x;

		for (int i = 1; i <= n; i++) {
			answer[i - 1] = temp * i;
		}
		return answer;
	}
}
