
public class CodingTest22 {
	public static void main(String[] args) {
		solution("123");
	}

	/**
	 * 자리수 더하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12931)
	 * 
	 * @param n 자연수
	 * @return 자연수 각 자리수 합
	 */
	public static int solution(int n) {
		int answer = 0;

		while (n != 0) {
			answer = answer + (n % 10);
			
			n = n / 10;
		}
		
		return answer;
	}
}
