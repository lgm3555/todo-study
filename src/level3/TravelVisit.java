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
}
