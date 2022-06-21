import java.util.ArrayList;
import java.util.Arrays;

public class CodingTest9 {
	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int divisor = 5;
		
		solution(arr, divisor);
	}

	/**
	 * 나누어 떨어지는 숫자 배열 Solution (https://programmers.co.kr/learn/courses/30/lessons/12910)
	 * 
	 * @param arr 숫자 목록
	 * @return 연속적으로 나타나는 숫자 제거후 숫자 배열
	 */
	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		ArrayList<Integer> tempArr = new ArrayList<>();

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				tempArr.add(arr[i]);
			}
		}
		
		if (tempArr.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
			
			return answer;
		} else {
			answer = new int[tempArr.size()];
		}
		
		for (int j=0; j < answer.length; j++) {
			answer[j] = tempArr.get(j);
		}
		
		return answer;
	}
}
