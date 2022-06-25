package level3;

import java.util.*;

public class Network_0625 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }

    public static HashMap<Integer, Integer> map;
    public static int solution(int n, int[][] computers) {
        Stack<ArrayList<Integer>> stack = new Stack<>();

        for (int i=0; i<computers.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0; j<computers.length; j++) {
                list.add(computers[i][j]);
            }
            stack.add(list);
            map.put(i, 0);
        }
        System.out.println(map);
        //dfs(stack, n, new ArrayList<Integer>());

        return 0;
    }

    private static void dfs(Stack<ArrayList<Integer>> stack, int parent, ArrayList<Integer> child) {
        Stack<ArrayList<Integer>> dfsStack = (Stack<ArrayList<Integer>>) stack.clone();

        if (!dfsStack.isEmpty()) {
            ArrayList<Integer> list = dfsStack.pop();
            System.out.println("list = " + list);
            for (int i=0; i<list.size(); i++) {
                if (list.get(i) == 1 && i != parent - 1) {
                    child.add(i);
                }
            }
            System.out.println("child = " + child);
            for (int i = 0; i < child.size(); i++) {
                map.put(child.get(i), parent);
            }
            child.removeAll(child);

            dfs (dfsStack, parent-1, child);
        }
    }
}
