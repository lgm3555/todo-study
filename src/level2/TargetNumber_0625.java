package level2;

import java.util.*;

public class TargetNumber_0625 {
    public static int answer;

    public static void main(String[] args) {
        TargetNumber_0625 targetNumber_0625 = new TargetNumber_0625();
        System.out.println(targetNumber_0625.solution(new int[] {1,1,1,1,1}, 3));
    }

    /**
     * 타겟 넘버 Solution (https://programmers.co.kr/learn/courses/30/lessons/43165)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int solution(int[] numbers, int target) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<numbers.length; i++) {
            stack.add(numbers[i]);
        }
        stack.add(0);

        dfs(stack, target, 0, 0);
        return answer / 2;
    }

    public void dfs(Stack<Integer> stack, int target, int check, int hap) {
        Stack<Integer> dfsStack = (Stack<Integer>) stack.clone();
        if (!dfsStack.isEmpty()) {
            hap += dfsStack.pop() * check;
            dfs(dfsStack, target, 1, hap);
            dfs(dfsStack, target, -1, hap);
        } else {
            if (hap == target) {
                answer++;
            };
        }
    }
}
