import java.util.Arrays;
import java.util.Comparator;

public class CodingTest15 {
	public static void main(String[] args) {
		String[] seoul = { "Jane", "Kim" };

		solution(seoul);
	}

	/**
	 * 서울에서 김서방 찾기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12919)
	 * 
	 * @param seoul 이름 배열
	 * @return 김서방의 위치
	 */
	public static String solution(String[] seoul) {
		String answer = "";

		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				answer = "김서방은 " + i + "에 있다";
				break;
			}
		}
		return answer;
	}
}
