import java.util.Scanner;

public class CodingTest36 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
		solution(a, b);
	}

	/**
	 * 직사각형 별찍기 Solution (https://programmers.co.kr/learn/courses/30/lessons/12969)
	 * 
	 * @param a 자연수
	 * @param b 자연수
	 */
	public static void solution(int a, int b) {
        for (int i=0; i<b; i++) {
            for (int j=0; j<a; j++) {
                System.out.printf("*");
            }
            System.out.println("");
        }
	}
}
