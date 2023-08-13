package dfs_bfs;

import java.util.Stack;

public class TargetNumber_0625 {
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
    private static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0);

        return answer;
    }

    private static void dfs(int[] numbers, int cursor, int target, int result) {
        if (cursor == numbers.length) {
            System.out.println(result + " - " + cursor + " **** ");
            if (result == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, cursor + 1, target, result + (numbers[cursor] * 1));
        dfs(numbers, cursor + 1, target, result + (numbers[cursor] * -1));
    }


    public int solution_0625(int[] numbers, int target) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<numbers.length; i++) {
            stack.add(numbers[i]);
        }
        stack.add(0);

        dfs_0625(stack, target, 0, 0);
        return answer;
    }

    public void dfs_0625(Stack<Integer> stack, int target, int check, int hap) {
        Stack<Integer> dfsStack = (Stack<Integer>) stack.clone();
        if (!dfsStack.isEmpty()) {
            hap += dfsStack.pop() * check;

            if (hap == target && dfsStack.size() == 0) {
                answer++;
            };

            dfs_0625(dfsStack, target, 1, hap);
            dfs_0625(dfsStack, target, -1, hap);
        }
    }
}
