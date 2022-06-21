
public class CodingTest34 {
	public static void main(String[] args) {
		int arr1[][] = { { 1, 2 }, { 2, 3 } };
		int arr2[][] = { { 3, 4 }, { 5, 6 } };

		solution(arr1, arr2);
	}

	/**
	 * 행렬의 덧셈 Solution (https://programmers.co.kr/learn/courses/30/lessons/12950)
	 * 
	 * @param arr1 같은 행과 열을 가지는 배열
	 * @param arr2 같은 행과 열을 가지는 배열
	 * @return 두 행렬의 덧셈의 결과
	 */
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];

		for (int i=0; i < arr1.length; i++) {
			for (int j=0; j < arr1[i].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}
}
