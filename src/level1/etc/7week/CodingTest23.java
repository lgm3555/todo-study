
public class CodingTest23 {
	public static void main(String[] args) {
		solution(12345);
	}

	/**
	 * 자연수 뒤집어 배열로 만들기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12932)
	 * 
	 * @param n 자연수
	 * @return 자연수를 뒤집어 각 자리 숫자를 원소로 가지는 배열
	 */
	public static int[] solution(long n) {
		String temp = Long.toString(n);
		int[] answer = new int[temp.length()];

		for (int i = temp.length() - 1, j = 0; i >= 0; i--, j++) {
			answer[j] = temp.charAt(i) - '0';
		}

		return answer;
	}
}
