import java.util.Stack;

public class CodingTest14 {
	public static void main(String[] args) {
		String s = "a234";

		solution(s);
	}

	/**
	 * 문자열 다루기 기본 Solution (https://programmers.co.kr/learn/courses/30/lessons/12918)
	 * 
	 * @param s 문자열
	 * @return 숫자로만 구성되어 길이가 4,6이면 true, 아니면 false
	 */
	public static boolean solution(String s) {
		if (s.length() == 4 || s.length() == 6) {
			return s.matches("^[0-9]*$")
		} else {
			return false;
		}
	}
}
