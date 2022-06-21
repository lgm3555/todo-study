
public class CodingTest19 {
	public static void main(String[] args) {
		solution("AB", 1);
	}

	/**
	 * 시저 암호 Solution (https://programmers.co.kr/learn/courses/30/lessons/12926)
	 * 
	 * @param s 문자열
	 * @param n 거리
	 * @return 문자열의 거리 길이만큼 민 문자열
	 */
	public static String solution(String s, int n) {
		String answer = "";
		int temp = 0;
		char[] c = new char[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			temp = (int)s.charAt(i);

			if (temp > 64 && temp < 91) {
				temp += n;
				
				if (temp > 90) {
					temp = temp - 90 + 64;
				}
				
			} else if (temp > 96 && temp < 123) {
				temp += n;
				
				if (temp > 122) {
					temp = temp - 122 + 96;
				}
			}

			c[i] = (char)temp;
		}

		answer = String.valueOf(c);

		return answer;
	}
}
