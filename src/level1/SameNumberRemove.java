package level1;

import java.util.ArrayList;

public class SameNumberRemove {
    public static void main(String[] args) {
        solution(new int[] {1,1,3,3,0,1,1});
    }

    /**
     * 같은 숫자는 싫어 Solution (https://school.programmers.co.kr/learn/courses/30/lessons/12906)
     *
     * @param arr
     * @return
     */
    public static int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1])list.add(arr[i]);
            if(i==arr.length-2)list.add(arr[arr.length-1]);
        }

        answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
