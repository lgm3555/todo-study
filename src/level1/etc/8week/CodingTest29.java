
public class CodingTest29 {
	public static void main(String[] args) {
		solution(3);
	}

	/**
	 * 최대공약수와 최소공배수 Solution (https://programmers.co.kr/learn/courses/30/lessons/12940)
	 * 
	 * @param num 자연수
	 * @return 자연수를 뒤집어 각 자리 숫자를 원소로 가지는 배열
	 */
	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		int a, b;
		
		if (n > m) {
			a = n;
			b = m;
		} else {
			a = m;
			b = n;
		}
		answer[0] = gcd(a, b);
		answer[1] = a * b / answer[0];
		
        return answer;
	}
	
	public int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}
