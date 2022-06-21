import java.util.HashSet;

public class CodingTest4 {
	public static void main(String[] args) {
		int[] lost = { 2,3,4 };
		int[] reserve = { 1,3,5 };

		solution(5, lost, reserve);
	}

	/**
	 * 체육복 Solution (https://programmers.co.kr/learn/courses/30/lessons/42862)
	 * 
	 * @param n 학생 인원
	 * @param lost 잃어버린 학생 번호 
	 * @param reserve 빌려줄수 있는 학생 번호 
	 * @return
	 */
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		HashSet<Integer> reservedList = new HashSet<>();
		HashSet<Integer> lostList = new HashSet<>();

		//HashSet에 빌려줄수 있는 학생 정보를 담기
		for (int i = 0; i < reserve.length; i++) {
			reservedList.add(reserve[i]);
		}

		//잃어버린 학생 번호로 for문
		for (int i = 0; i < lost.length; i++) {
			//빌려줄수 있는 학생 정보에 잃어버린 학생 번호가 있는지 확인
			if (reservedList.contains(lost[i])) {
				//번호가 있으면 빌려줄수 있는 학생도 잃어버린경우이기 떄문에 누구도 빌려줄수 없어서 remove처리
				reservedList.remove(lost[i]);
			} else {
				//번호가 없을 경우 lostList에 담기 (빌려줄수 있는 학생 번호)
				lostList.add(lost[i]);
			}
		}

		//잃어버린 학생정보 lost로 for문
		for (int i = 0; i < lost.length; i++) {
			//빌려줄수있는 학생중에 잃어버린 학생 번호가 있는지
			if (lostList.contains(lost[i])) {
				//사이로 빌려줄수 있기때문에 아래 번호가 있는지 확인
				if (reservedList.contains(lost[i] - 1)) {
					//번호가 있을경우 제거
					reservedList.remove(lost[i] - 1);
				} else if (reservedList.contains(lost[i] + 1)) {
					//윗 번호가 있으면 제거
					reservedList.remove(lost[i] + 1);
				} else {
					//윗번호 아래번호 없을경우 전체 학생수에서 -1
					answer = answer - 1;
				}
			}
		}
		return answer;
    }
}
