package level1;

import java.util.ArrayList;

public class ParkWalk_230327 {
    public static void main(String[] args) {
        //[2, 1]
        solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
        //[0, 1]
        solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
        //[0, 0]
        solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"});
    }

    /**
     * 공원 산책 (https://school.programmers.co.kr/learn/courses/30/lessons/172928)
     *
     * @param park 공원 배열
     * @param routes 이동 기록록
    * @return
     */
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startX = 0;
        int startY = 0;
        int tableX = park[0].length();
        int tableY = park.length;
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<park.length; i++) {
            String[] s = park[i].split("");
            for (int j=0; j<s.length; j++) {
                if (s[j].equals("S")) {
                    startX = j;
                    startY = i;
                } else if (s[j].equals("X")) {
                    list.add(i + "-" + j);
                }
            }
        }

        int moveX = startX;
        int moveY = startY;
        boolean chk = false;
        for (int i=0; i<routes.length; i++) {
            String[] s = routes[i].split(" ");
            chk = false;

            int tempX = moveX;
            int tempY = moveY;

            for (int j=0; j<Integer.parseInt(s[1]); j++) {
                if (s[0].equals("N")) {
                    moveY = moveY - 1;
                } else if (s[0].equals("S")) {
                    moveY = moveY + 1;
                } else if (s[0].equals("W")) {
                    moveX = moveX - 1;
                } else if (s[0].equals("E")) {
                    moveX = moveX + 1;
                }

                System.out.println(moveY + "," + moveX);

                if (list.contains(moveY + "-" + moveX)) {
                    chk = true;
                    break;
                } else if (moveY >= tableY || moveX >= tableX) {
                    chk = true;
                    break;
                } else if (moveY < 0 || moveX < 0) {
                    chk = true;
                    break;
                }
            }

            if (chk) {
                moveX = tempX;
                moveY = tempY;
            }
        }

        answer[0] = moveY;
        answer[1] = moveX;

        return answer;
    }
}
