import java.util.Arrays;
import java.util.Comparator;

public class CodingTest13 {
	public static void main(String[] args) {
		String s = "Zbcdefg";

		solution(s);
	}

	/**
	 * 문자열 내림 차순으로 배치하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12917)
	 * 
	 * @param s 문자열
	 * @return 큰것부터 작은순으로 정렬하여 반환하는 문자열
	 */
	public static String solution(String s) {
		String answer = "";
		String[] str = s.split("");

		Arrays.sort(str, Comparator.reverseOrder());

		for (int i = 0; i < str.length; i++) {
			answer = answer + str[i];
		}

		return answer;
	}
}
