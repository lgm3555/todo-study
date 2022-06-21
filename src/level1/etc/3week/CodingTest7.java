
public class CodingTest7 {
	public static void main(String[] args) {
		String s = "abcde";

		System.out.println(solution(s));
	}

	/**
	 * 가운데 글자 가져오기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12903)
	 * 
	 * @param s 단어
	 * @return 단어의 가운데 글자
	 */
	public static String solution(String s) {
		String answer = "";
		
		if (s.length() % 2 == 0) {
			answer = s.substring((s.length() / 2) - 1, (s.length() / 2) + 1); 
		} else {
			answer = s.substring((s.length() / 2), (s.length() / 2) + 1);
		}
		
		return answer;
	}
}
