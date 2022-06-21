import java.util.HashMap;

public class CodingTest28 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		solution(arr, "right");
	}

	/**
	 * 키패드 누르기 Solution (https://programmers.co.kr/learn/courses/30/lessons/67256)
	 * 
	 * @param num 자연수
	 * @return 자연수를 뒤집어 각 자리 숫자를 원소로 가지는 배열
	 */
	public static String solution(int[] numbers, String hand) {
		HashMap<Integer, int[]> side = new HashMap<Integer, int[]>();
		HashMap<Integer, int[]> center = new HashMap<Integer, int[]>();

		center.put(0, new int[] { 3, 1 });
		for (int i = 0, j = 1, k = 0; i < 3; i++, j += 3) {
			side.put(j, new int[] { i, k });
			center.put(j + 1, new int[] { i, k + 1 });
			side.put(j + 2, new int[] { i, k + 2 });
		}

		int leftRow = 3;
		int leftCol = 0;

		int rightRow = 3;
		int rightCol = 2;
		int rightTemp, leftTemp;
		StringBuilder sb = new StringBuilder();
		int[] temp;

		for (int i = 0; i < numbers.length; i++) {
			if (center.containsKey(numbers[i])) {
				temp = center.get(numbers[i]);
				rightTemp = Math.abs(temp[0] - rightRow) + Math.abs(temp[1] - rightCol);
				leftTemp = Math.abs(temp[0] - leftRow) + Math.abs(temp[1] - leftCol);
				if (rightTemp == leftTemp) {
					if (hand.equals("right")) {
						sb.append("R");
						rightRow = temp[0];
						rightCol = temp[1];
					} else {
						sb.append("L");
						leftRow = temp[0];
						leftCol = temp[1];
					}
				} else if (rightTemp < leftTemp) {
					sb.append("R");
					rightRow = temp[0];
					rightCol = temp[1];
				} else {
					sb.append("L");
					leftRow = temp[0];
					leftCol = temp[1];
				}
			} else {
				if (numbers[i] % 3 == 0) {
					sb.append("R");
					temp = side.get(numbers[i]);
					rightRow = temp[0];
					rightCol = temp[1];
				} else {
					sb.append("L");
					temp = side.get(numbers[i]);
					leftRow = temp[0];
					leftCol = temp[1];
				}
			}
		}
		return sb.toString();
	}
}
