package level2;

import java.util.ArrayList;
import java.util.Arrays;

public class UpNumber {
    public static void main(String[] args) {
        solution("4177252841", 4);
    }

    public static String solution(String number, int k) {
        String answer = "";

        ArrayList<String> list = new ArrayList<>(Arrays.asList(number.split("")));

        int temp = 0;
        int start = 0;
        int finish = list.size() - k;
        while (true) {
            System.out.println("start = " + start + " finish = " + finish);
            for (int j=start; j<finish; j++) {
                if (Integer.parseInt(list.get(j)) > temp) {
                    temp = Integer.parseInt(list.get(j));
                    start = j;
                }
            }
            finish = finish == list.size() ? list.size() : finish++;
            System.out.println("temp = " + temp);
            answer += temp;
            temp = 0;

            if (answer.length() == list.size()-k) {
                break;
            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
// 10 = 4177252841
// 0 ~ 6 = 4177252
// 2 ~ 7 = 72528
//
