import java.util.Arrays;

public class CodingTest24 {
	public static void main(String[] args) {
		solution(118372);
	}

	/**
	 * 정수 내림차순으로 배치하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12933)
	 * 
	 * @param n 자연수
	 * @return 자연수를 내림차순으로 정렬
	 */
	public static long solution(long n) {
        String answer = "";
        String temp = Long.toString(n);
        int[] arr = new int[temp.length()];
        
		for (int i = 0; i < temp.length(); i++) {
			arr[i] = temp.charAt(i) - '0';
		}

		Arrays.sort(arr);
		
		for (int j = arr.length - 1; j >= 0; j--) {
			answer += arr[j];
		}

		return Integer.parseInt(answer);
    }
}
