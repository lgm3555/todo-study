package level3;

import java.util.*;

public class TravelVisit {

    public static void main(String[] args) {

        /*
        solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println("ICN-JFK-HND-IAD");

        solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        System.out.println("ICN-ATL-ICN-SFO-ATL-SFO");
        */

        solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}});
        System.out.println("ICN-AOO-BOO-COO-DOO-EOO-DOO-COO-BOO-AOO");

        /*
        solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"AOO", "COO"}, {"COO", "AOO"}, {"BOO", "ZOO"}});
        System.out.println("ICN-AOO-COO-AOO-BOO-ZOO");

        solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"AOO", "BOO"}, {"BOO", "AOO"}, {"BOO", "FOO"}, {"FOO", "COO"}, {"COO", "ZOO"}});
        System.out.println("ICN-AOO-BOO-AOO-BOO-FOO-COO-ZOO");
         */
    }

    public static HashMap<String, ArrayList<String>> graph = new HashMap<>();
    public static ArrayList<String> tempAnswer = new ArrayList<>();

    /**
     * 여행 경로 (https://school.programmers.co.kr/learn/courses/30/lessons/43164)
     *
     * @param tickets
     * @return
     */
    public static String[] solution(String[][] tickets) {

        return new String[] {};
    }

    /*
    public static HashMap<String, ArrayList<String>> graph = new HashMap<>();
    public static HashMap<String, Boolean> visit = new HashMap<>();
    public static ArrayList<String> tempAnswer = new ArrayList<>();
    public static String[] solution(String[][] tickets) {

        for (int i=0; i<tickets.length; i++) {
            graph.put(tickets[i][0], new ArrayList<>());
        }

        for (int i=0; i<tickets.length; i++) {
            ArrayList<String> subList = new ArrayList<>();
            subList.add(tickets[i][1]);
            for (int j=0; j<tickets.length; j++) {
                if (tickets[i][0].equals(tickets[j][0]) && i != j) {
                    subList.add(tickets[j][1]);
                }
            }
            Collections.sort(subList);
            graph.put(tickets[i][0], subList);
        }

        System.out.println("graph = " + graph);

        dfs("ICN", tickets.length);

        String[] answer = new String[tempAnswer.size()];
        for (int i=0; i<tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }

    public static void dfs(String startNode, int ticketNum) {
        Stack<String> stack = new Stack<>();
        stack.push(startNode);
        tempAnswer.add(startNode);

        while (!stack.isEmpty()) {
            String x = stack.pop();

            if (ticketNum != tempAnswer.size()-1 && stack.isEmpty() && graph.get(x).size() == 0) {
                String temp = tempAnswer.get(tempAnswer.size() - 1);
                tempAnswer.remove(tempAnswer.size() - 1);
                graph.get(tempAnswer.get(tempAnswer.size() - 1)).add(temp);
                x = graph.get(tempAnswer.get(tempAnswer.size() - 1)).get(0);
                graph.get(tempAnswer.get(tempAnswer.size() - 1)).remove(0);
                tempAnswer.add(x);
            }

            System.out.println("x = " + x);
            System.out.println("stack = " + stack);

            if (graph.get(x) == null) {
                continue;
            }

            if (graph.get(x).size() != 0) {
                stack.push(graph.get(x).get(0));
                tempAnswer.add(graph.get(x).get(0));
                graph.get(x).remove(0);
            }
        }
    }
    */
}
