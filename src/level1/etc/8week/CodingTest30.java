
public class CodingTest30 {
	public static void main(String[] args) {
		solution(626331);
	}

	/**
	 * 콜라츠 추측 Solution (https://programmers.co.kr/learn/courses/30/lessons/12943)
	 * 
	 * @param num 자연수
	 * @return 자연수를 뒤집어 각 자리 숫자를 원소로 가지는 배열
	 */
	public static int solution(int num) {
		long n = (long)num;
		
        for (int i=0; i<500; i++) {

        	if (num == 1) {
        		return i;
        	} else {
        		if (num % 2 == 0) {
        			num = num / 2;
        		} else {
        			num = (num * 3) + 1;
        		}
        	}
        }
        return -1;
	}
}
