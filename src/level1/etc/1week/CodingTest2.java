import java.util.Arrays;

public class CodingTest2 {
	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana", "tests" };
		String[] completion = { "stanko", "ana", "mislav" };

		System.out.println(solution(participant, completion));
	}

	/**
	 * 완주하지 못한 선수 Solution (https://programmers.co.kr/learn/courses/30/lessons/42576)
	 * 
	 * @param participant 도전하는 선수 목록
	 * @param completion 완주자 목록
	 * @return 완주하지 못한 선수 이름
	 */
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equalsIgnoreCase(completion[i])) {
				return participant[i];
			}
		}
		return participant[participant.length - 1];
	}
}
