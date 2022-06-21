import java.util.Arrays;

public class CodingTest5 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		solution(array, commands);
	}

	/**
	 * K번쨰수 Solution (https://programmers.co.kr/learn/courses/30/lessons/42748)
	 *  
	 * @param array 숫자 배열
	 * @param commands i,j 번째 잘라서 k번쨰 수 구하기 
	 * @return k번쨰에 있는 수
	 */
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int cnt = 0;

		for (int[] subCommand : commands) {
			int[] temp = Arrays.copyOfRange(array, subCommand[0] - 1, subCommand[1]);
			Arrays.sort(temp);
			answer[cnt] = temp[subCommand[2] - 1];
			cnt++;
		}

		return answer;
	}
}
