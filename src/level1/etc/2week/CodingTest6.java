
public class CodingTest6 {
	public static void main(String[] args) {
		System.out.println(solution(5, 6));
	}

	/**
	 * 2016 Solution (https://programmers.co.kr/learn/courses/30/lessons/12901)
	 * 
	 * @param a 월
	 * @param b 일 
	 * @return 요일
	 */
	public static String solution(int a, int b) {
    	String answer = "";
		String[] week = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int[] dayCount = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		int total = 0;
		
		for (int i=0; i<a-1; i++) {
			total = total + dayCount[i];
		}
		
		total = (total + b - 1) % 7;
		
		answer = week[total];
		
		return answer;
	}
}
