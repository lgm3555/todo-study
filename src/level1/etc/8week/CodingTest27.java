
public class CodingTest27 {
	public static void main(String[] args) {
		solution(3);
	}

	/**
	 * 짝수와 홀수 Solution (https://programmers.co.kr/learn/courses/30/lessons/12937)
	 * 
	 * @param num 자연수
	 * @return 자연수를 뒤집어 각 자리 숫자를 원소로 가지는 배열
	 */
	public static String solution(int num) {
		if (num % 2 == 0) {
			return "Even";
		} else {
			return "Odd";
		}
	}
}
