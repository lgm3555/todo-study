import java.util.LinkedList;

public class CodingTest3 {
	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1 };

		System.out.println(solution(answers));
	}

	/**
	 * 모의고사 Solution (https://programmers.co.kr/learn/courses/30/lessons/42840)
	 * 
	 * @param answers 문제 답
	 * @return 높은 점수를 받은 사람을 오름차순하여 반환
	 */
	public static int[] solution(int[] answers) {
		// 수포자 1,2,3번이 찍는 방식
		int[] st1 = { 1, 2, 3, 4, 5 };
		int[] st2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] st3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, };
		// 찍었을 경우 맞은 갯수를 담을 배열
		int[] score = new int[3];

		// 찍는 방식이 반복되기 떄문에 찍는 방식의 길이를 나누어서 정답과 같으면 score에 +1
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == st1[i % 5]) {
				score[0]++;
			}
			if (answers[i] == st2[i % 8]) {
				score[1]++;
			}
			if (answers[i] == st3[i % 10]) {
				score[2]++;
			}
		}

		LinkedList<Integer> list = new LinkedList<Integer>();

		// 가장 높은 점수
		int max = 0;
		// 가장 높은 점수를 받은사람을 찾기위한 for문
		for (int i = 0; i < 3; ++i) {
			if (score[i] > max) { // 점수가 높은 사람이 한명일 경우.
				list = new LinkedList<Integer>();
				list.add(i + 1);
				max = score[i];
			} else if (score[i] == max) {// 점수가 높은 사람이 여러명일 경우.
				list.add(i + 1);
			}
		}

		// 가장 많은 문제를 맞힌 사람을 배열로 담아 return
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
