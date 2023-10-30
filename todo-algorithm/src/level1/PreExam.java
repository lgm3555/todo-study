package level1;

import java.util.ArrayList;

public class PreExam {
    public static void main(String[] args) {
        PreExam preExam = new PreExam();
        preExam.solution(new int[] {1,2,3,4,5});
    }

    /**
     * 모의고사 (https://school.programmers.co.kr/learn/courses/30/lessons/42840)
     *
     * @param answers
     * @return
     */
    public int[] solution(int[] answers) {
        int[] people1 = {1, 2, 3, 4, 5};
        int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int i=0;
        int j=0;
        int k=0;
        int[] circle = {0, 0, 0};
        for (int answer : answers) {
            if (people1.length == i) i = 0;
            if (people2.length == j) j = 0;
            if (people3.length == k) k = 0;

            if (answer == people1[i]) {
                circle[0]++;
            }

            if (answer == people2[j]) {
                circle[1]++;
            }

            if (answer == people3[k]) {
                circle[2]++;
            }

            i++;j++;k++;
        }

        int max = Math.max(Math.max(circle[0], circle[1]), circle[2]);

        ArrayList<Integer> list = new ArrayList<>();
        for (int c=0; c<circle.length; c++) {
            if (circle[c] == max) {
                list.add(c+1);
            }
        }

        int[] result = new int[list.size()];
        for (int l=0; l<list.size(); l++) {
            result[l] = list.get(l);
        }

        return result;
    }
}
