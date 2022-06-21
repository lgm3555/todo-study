
public class CodingTest40 {
	public static void main(String[] args) {
		int arr1[] = { 9, 10, 28, 18, 11 };
		int arr2[] = { 30, 1, 21, 17, 28 };

		solution(5, arr1, arr2);
	}

	/**
	 * 비밀지도 Solution (https://programmers.co.kr/learn/courses/30/lessons/17681)
	 * 
	 * @param n 정사각형 지도 크기
	 * @param arr1 지도 1
	 * @param arr2 지도 2
	 * @return 지도
	 */
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String temp1 = "";

		for (int i = 0; i < arr1.length; i++) {
			temp1 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i]))).replace("1", "#").replace("0", " ");

			answer[i] = temp1;
		}
		return answer;
	}
}
