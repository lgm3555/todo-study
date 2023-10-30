package level3;

import java.util.*;

//TODO 공부
public class TravelVisit {

    public static void main(String[] args) {
        solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println("ICN-JFK-HND-IAD");

        /*
        solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}});
        System.out.println("ICN, BOO, DOO, BOO, ICN, COO, DOO, COO, BOO");
        */

        /*
        solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        System.out.println("ICN-ATL-ICN-SFO-ATL-SFO");
        */

        /*
        solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}});
        System.out.println("ICN-AOO-BOO-COO-DOO-EOO-DOO-COO-BOO-AOO");
        */

        /*
        solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"AOO", "COO"}, {"COO", "AOO"}, {"BOO", "ZOO"}});
        System.out.println("ICN-AOO-COO-AOO-BOO-ZOO");

        solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"AOO", "BOO"}, {"BOO", "AOO"}, {"BOO", "FOO"}, {"FOO", "COO"}, {"COO", "ZOO"}});
        System.out.println("ICN-AOO-BOO-AOO-BOO-FOO-COO-ZOO");
        */
    }

    static boolean[] visited;
    static ArrayList<String> allRoute;

    /**
     * 여행 경로 (https://school.programmers.co.kr/learn/courses/30/lessons/43164)
     *
     * @param tickets
     * @return
     */
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    public static void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            //System.out.println("route = " + route);
            allRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                //System.out.println("1. " + route + "----" +  Arrays.toString(visited));
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
                //System.out.println("2" + Arrays.toString(visited));
            }
        }
    }
}