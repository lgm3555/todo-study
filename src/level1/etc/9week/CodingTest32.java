
public class CodingTest32 {
	public static void main(String[] args) {
		solution(10);
	}

	/**
	 * 하샤드 수 Solution (https://programmers.co.kr/learn/courses/30/lessons/12947)
	 * 
	 * @param x 자연수
	 * @return 하샤드 수를 검사
	 */
	public static boolean solution(int x) {
		int sum = 0;
		int temp = x;
		
		while (temp > 0) {
			sum += temp % 10;
			
			temp /= 10;
		}

		if (x % sum == 0) {
			return true;
		} else {
			return false;
		}
    }
}
