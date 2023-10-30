package level1;

import java.util.Stack;

public class BackOverNum_230323 {
    public static void main(String[] args) {
        // 3,5,5,-1
        solution(new int[]{2,3,3,5});
        //-1,5,6,6,-1,-1
        //solution(new int[]{9,1,5,3,6,2});
    }

    /**
     * 뒤에 있는 큰 수 찾기 (https://school.programmers.co.kr/learn/courses/30/lessons/154539)
     *
     * @param numbers
     * @return
     */
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (numbers[i]<numbers[i-1]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        return answer;
    }

    public static int[] solution1(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            int temp = -1;
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    temp = numbers[j];
                    break;
                }
            }
            answer[i] = temp;
        }

        return answer;
    }
}
