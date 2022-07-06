package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreDivide {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,7,8,10,15}, 3));
    }

    //정렬 기준은 interval
    public static class IntervalNode implements Comparable<IntervalNode> {
        int interval;
        int index;

        public IntervalNode(int interval, int index) {
            this.interval = interval;
            this.index = index;
        }
        @Override
        public int compareTo(IntervalNode next) {
            return next.interval - this.interval;
        }

        @Override
        public String toString() {
            return "IntervalNode{" +
                    "interval=" + interval +
                    ", index=" + index +
                    '}';
        }
    }

    /**
     * 한화생명 코딩테스트 2번 문제 (점수로 조 나누기)
     * 정렬된 scores에서 인접한 학생들끼리 조를 나눔
     * 각 조에서 가장 점수가 높은 학생의 점수와 가장 점수가 낮은 학생의 점수의 차이를 구한 후, 차이의 합이 최소가 되도록 조를 나눠야함.
     *
     * @param scores
     * @param k 조 개수
     * @return
     */
    public static int solution(int[] scores, int k) {
        int answer = 0;
        int n = scores.length;

        IntervalNode[] intervalDiffs = new IntervalNode[n - 1];
        // 인접한 학생이랑 점수 차
        for (int i = 0; i < n - 1; i++) {
            int interval = scores[i + 1] - scores[i];
            intervalDiffs[i] = new IntervalNode(interval, i);
        }

        System.out.println("Arrays.toString(intervalDiffs) = " + Arrays.toString(intervalDiffs));
        //점수 차 기준 정렬
        Arrays.sort(intervalDiffs);
        System.out.println("Arrays.toString(intervalDiffs) = " + Arrays.toString(intervalDiffs));

        // score 점수 ArrayList로 이동
        List<Integer> scoresList = new ArrayList<Integer>();
        for (int i : scores) {
            scoresList.add(i);
        }

        System.out.println("scoresList = " + scoresList);

        int[] splitIndexs = new int[k - 1];
        //조를 나누는 인덱스 번호
        for (int i=0; i<k-1; i++) {
            splitIndexs[i] = intervalDiffs[i].index + 1;
        }

        System.out.println("Arrays.toString(splitIndexs) = " + Arrays.toString(splitIndexs));
        Arrays.sort(splitIndexs);
        System.out.println("Arrays.toString(splitIndexs) = " + Arrays.toString(splitIndexs));

        int beforeIdx = 0;
        for (int i = 0; i < splitIndexs.length; i++) {
            int cutIdx = splitIndexs[i];

            if (beforeIdx != cutIdx) {
                List<Integer> subList = scoresList.subList(beforeIdx, cutIdx);
                System.out.println("subList.size() = " + subList.size());
                System.out.println("subList = " + subList);

                //가장 높은 점수 - 가장 낮은 점수 구해서 더하기
                answer = answer + (subList.get(subList.size() - 1) - subList.get(0));
            }

            beforeIdx = cutIdx;
        }

        List<Integer> subList = scoresList.subList(beforeIdx, scoresList.size());
        //마지막 조 가장 높은 점수 - 가장 낮은 점수 구해서 더하기
        answer = answer + (subList.get(subList.size() - 1) - subList.get(0));
        return answer;
    }
}