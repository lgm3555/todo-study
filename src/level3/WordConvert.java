package level3;

import java.util.*;

public class WordConvert {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot","dot","dog","lot","log"}));
    }

    static final int INF = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<String>> graph = new ArrayList<>();
    public static boolean[] visit;
    public static ArrayList<String> subWord = new ArrayList<>();
    public static int answer = 0;

    public static void bfs(int startNode, int check) {
        Queue<Integer> queue = new LinkedList<>();
        visit[startNode] = true;
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            System.out.println("queue = " + queue);
            int x = queue.poll();
            for (int i=0; i<graph.get(x).size(); i++) {
                int y = subWord.indexOf(graph.get(x).get(i));
                if (check == y) return;
                if (!visit[y]) {
                    visit[y] = true;
                    queue.offer(y);
                }
            }
            answer++;
            System.out.println("answer = " + answer);
        }
    }

    public static int solution(String begin, String target, String[] words) {

        boolean bFlag = false;

        for (int i=0; i<words.length; i++) {
            subWord.add(words[i]);
            if (words[i].equals(target)) bFlag = true;
        }

        if (bFlag) return 0;

        subWord.add(begin);

        visit = new boolean[subWord.size()];

        System.out.println("subWord.toString()) = " + subWord.toString());

        for (int i=0; i<subWord.size(); i++) {
            ArrayList<String> subList = new ArrayList<>();
            for (int j=0; j<subWord.size(); j++) {
                int same = 0;
                if (!subWord.get(i).equals(subWord.get(j))) {
                    for (int k=0; k<subWord.get(j).length(); k++) {
                        if (subWord.get(i).charAt(k) == subWord.get(j).charAt(k)) {
                            same++;
                        }
                    }
                }
                if (subWord.get(j).length() - 1 == same) {
                    subList.add(subWord.get(j));
                }
            }
            graph.add(subList);
        }

        for (int i=0; i<graph.size(); i++) {
            System.out.println(i + " _ " + subWord.get(i) + " = " + graph.get(i).toString());
        }

        System.out.println("subWord.indexOf(target) = " + subWord.indexOf(target));
        
        bfs(subWord.size()-1, subWord.indexOf(target));

        return answer;
    }
}