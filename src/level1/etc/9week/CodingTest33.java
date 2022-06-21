
public class CodingTest33 {
	public static void main(String[] args) {
		solution("01033334444");
	}

	/**
	 * 핸드폰 번호 가리기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12948)
	 * 
	 * @param phone_number 폰번호
	 * @return *로 가린 폰 번호
	 */
	public static String solution(String phone_number) {
		String answer = "";

		answer = phone_number.substring(0, phone_number.length()-4).replaceAll("[0-9]", "*") + phone_number.substring(phone_number.length()-4, phone_number.length());
		
		//return phone_number.replaceAll(".(?=.{4})", "*");
		
		return answer;
	}
}
