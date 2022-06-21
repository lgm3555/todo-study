import java.util.Arrays;

public class CodingTest37 {
	public static void main(String[] args) {
		int d[] = {1, 3, 2, 5, 4};

		solution(d, 9);
	}

	/**
	 * 예산 Solution (https://programmers.co.kr/learn/courses/30/lessons/12982)
	 * 
	 * @param d 신청 금액
	 * @param budget 예산 총 금액
	 * @return 지원 가능한 부서 
	 */
	public static int solution(int[] d, int budget) {
		int answer = 0;
        int hap = 0;
        
        Arrays.sort(d);
        
        for (int temp : d) {
        	hap += temp;
        	if (budget < hap) {
        		break;
        	}
        	answer++;
        }
        
        return answer;
    }
}
