import java.util.Stack;

public class CodingTest8 {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

		solution(arr);
	}

	/**
	 * 가운데 숫자는 싫어 Solution (https://programmers.co.kr/learn/courses/30/lessons/12906)
	 * 
	 * @param arr 숫자 목록
	 * @return 연속적으로 나타나는 숫자 제거후 숫자 배열
	 */
	public static int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();

		for (int a : arr) {
			if (!stack.empty()) {
				if (stack.peek() == a) {
					stack.pop();
				}
			}
			stack.push(a);
		}

		int[] answer = new int[stack.size()];

		while (!stack.empty()) {
			answer[stack.size() - 1] = stack.pop();
		}

		return answer;
	}
}
