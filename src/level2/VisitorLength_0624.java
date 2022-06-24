package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class VisitorLength_0624 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    /**
     * 방문 길이 Solution (https://programmers.co.kr/learn/courses/30/lessons/49994)
     *
     * @param dirs
     * @return
     */
    public static int solution(String dirs) {
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        String[] dirsArr = dirs.split("");

        int x = 0;
        int y = 0;
        xList.add(x);
        yList.add(y);
        for (int i=0; i<dirsArr.length; i++) {
            if (dirsArr[i].equals("U")) {
                y += 1;
            } else if (dirsArr[i].equals("D")) {
                y -= 1;
            } else if (dirsArr[i].equals("L")) {
                x -= 1;
            } else if (dirsArr[i].equals("R")) {
                x += 1;
            }

            if (y > 5) {
                y = 5;
                continue;
            } else if (y < -5) {
                y = -5;
                continue;
            }

            if (x > 5) {
                x = 5;
                continue;
            } else if (x < -5) {
                x = -5;
                continue;
            }

            xList.add(x);
            yList.add(y);
        }

        int answer = xList.size();
        for (int i=0; i<xList.size()-1; i++) {
            for (int j=i+1; j<yList.size()-1; j++) {
                //0,0 -> 0,1 == 0,0 -> 0,1
                if (xList.get(i) == xList.get(j) && yList.get(i) == yList.get(j)
                        && xList.get(i+1) == xList.get(j+1) && yList.get(i+1) == yList.get(j+1)) {
                    answer--;
                    break;
                }

                //0,0 -> 0,1 == 0,1 -> 0,0
                if (xList.get(i) == xList.get(j+1) && yList.get(i) == yList.get(j+1)
                        && xList.get(i+1) == xList.get(j) && yList.get(i+1) == yList.get(j)) {
                    answer--;
                    break;
                }
            }
        }

        return answer-1;
    }
}
