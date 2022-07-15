package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class UpNumber {
    public static void main(String[] args) {
        //775841
        solution("4197252841", 4);
        //65432
        //solution("654321", 1);
        //6
        //solution("654321", 5);

    }

    /**
     * 큰 수 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/42883)
     *
     * @param number
     * @param k
     * @return
     */
    public static String solution(String number, int k) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(number.split("")));

        int size = list.size();
        int temp = Integer.parseInt(list.get(0));
        for (int i=1; i<list.size(); i++) {

            if (size - k == list.size()) break;

            if (Integer.parseInt(list.get(i)) > temp) {
                list.remove(i-1);
                i = i-2 < 0 ? 0 : i-2;
            } else if (i == list.size()-1) {
                list.remove(i);
                i = i-2 < 0 ? 0 : i-2;
            }
            temp = Integer.parseInt(list.get(i));
        }

        for (int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}
