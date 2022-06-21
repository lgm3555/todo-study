import java.util.LinkedList;
import java.util.List;

public class CodingTest11 {
	public static void main(String[] args) {
		String[] strings = { "abce", "abcd", "cdx" };
		int n = 2;
		solution(strings, n);
	}

	/**
	 * 문자열 내 마음대로 정렬하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12915)
	 * 
	 * @param strings 문자열
	 * @param n       위치
	 * @return n위치에 따른 정렬
	 */
	public static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		List<String> list = new LinkedList<>();

		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i].substring(n, n + 1) + strings[i]);
		}

		list.sort(String::compareTo);

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).substring(1, list.get(i).length());
		}

		return answer;
	}
}
