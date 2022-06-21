
public class CodingTest21 {
	public static void main(String[] args) {
		solution("\"try hello");
	}

	/**
	 * 이상한 문자 만들기 Solution
	 * (https://programmers.co.kr/learn/courses/30/lessons/12930)
	 * 
	 * @param s 정수로 반환할 문자열
	 * @return 변경된 정수
	 */
	public static String solution(String s) {
		String answer = "";
		String[] array = s.split("");
		int cnt = 0;

		for (String ss : array) {
			cnt = ss.contains(" ") ? 0 : cnt + 1;

			answer += cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
		}
		
		return answer;
	}
}
