public class CodingTest25 {
	public static void main(String[] args) {
		solution(121);
	}

	/**
	 * 정수 제곱근 판별 Solution (https://programmers.co.kr/learn/courses/30/lessons/12934)
	 * 
	 * @param n 자연수
	 * @return x의 제곱이라면 x+1 제곱값 리턴
	 */
	public static long solution(long n) {
		double answer = Math.sqrt(n);
		
		if (Math.floor(answer) == answer) {
			return (long)(Math.pow(answer + 1, 2));
		} else {
			return -1;
		}
	}
}
