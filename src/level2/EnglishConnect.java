package level2;

import java.util.*;

public class EnglishConnect {
    public static void main(String[] args) {
        solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        /*
        solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"});
        solution(2, new String[] {"land", "dream", "mom", "mom", "ror"});
        solution(2, new String[] {"land", "dream", "mom", "mom"});
        solution(2, new String[] {"land", "d", "mom", "mom", "ror"});
        */
    }

    /**
     * 영어 끝말잇기 (https://school.programmers.co.kr/learn/courses/30/lessons/12981)
     *
     * @param n
     * @param words
     * @return
     */
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        int check = 0;

        list.add(words[0]);

        for (int i=1; i<words.length; i++) {
            if (list.contains(words[i])) { // 사용 유무
                check = i;
                System.out.println("check1 = " + check);
                break;
            } else if (words[i].length() == 1) { //단어가 1일 경우
                check = i;
                System.out.println("check2 = " + check);
                break;
            } else if (!words[i-1].substring(words[i-1].length()-1, words[i-1].length()).equals(words[i].substring(0, 1))) { // 단어 마지막 글자와 다음 단어 첫 글자 비교
                check = i;
                System.out.println("check3 = " + check);
                break;
            }

            list.add(words[i]);
        }

        if (check != 0) {
            // 1부터 시작으로 변경
            check = check + 1;
            answer[0] = check % n == 0 ? n : check % n;
            answer[1] = check % n == 0 ? check / n : check / n+1;
        }

        System.out.println("answer = " + Arrays.toString(answer));

        return answer;
    }
}