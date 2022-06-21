import java.util.Stack;

public class CodingTest12 {
	public static void main(String[] args) {
		String s = "pPoooyY";

		solution(s);
	}

	/**
	 * 문자열 내 p와 y의 개수 Solution (https://programmers.co.kr/learn/courses/30/lessons/12916)
	 * 
	 * @param s 문자열
	 * @return p와 y의 개수가 같으면 true, 다르면 false
	 */
	public static boolean solution(String s) {
		String[] str = s.toLowerCase().split("");
		int cnt = 0;

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("p")) {
				cnt = cnt + 1;
			} else if (str[i].equals("y")) {
				cnt = cnt - 1;
			}
		}

		if (cnt == 0) {
			return true;
		} else {
			return false;
		}
	}
}
