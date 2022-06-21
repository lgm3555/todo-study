
public class CodingTest31 {
	public static void main(String[] args) {
		solution([2, 5]);
	}

	/**
	 * 평균 구하기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12944)
	 * 
	 * @param arr 배열
	 * @return 배열의 평균값
	 */
	public static double solution(int[] arr) {
		double answer = 0;
        
        for (int temp : arr) {
            answer = answer + temp;
        }
        
        answer = answer / arr.length;
        
        return answer;
    }
}
