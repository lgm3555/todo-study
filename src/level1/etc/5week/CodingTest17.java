
public class CodingTest17 {
	public static void main(String[] args) {
		solution(1);
	}

	/**
	 * 수박수박수? Solution (https://programmers.co.kr/learn/courses/30/lessons/12922)
	 * 
	 * @param n 반환할 문자열의 길이
	 * @return n만큼 수박수박 패턴을 리턴
	 */
	public static String solution(int n) {
        String answer = "";

        for (int i=1; i<=n; i++) {
    		answer += (i%2 == 0) ? "박" : "수";
    	}

        return answer;
    }
}
