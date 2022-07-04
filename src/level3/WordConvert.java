package level3;

import java.util.*;

public class WordConvert {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot","dot","dog","lot","log","cog"}));
    }

    public static ArrayList<ArrayList<String>> graph = new ArrayList<>();
    public static boolean[] visit;
    public static ArrayList<String> subWord = new ArrayList<>();
    public static int answer = 0;

    public static void dfs(int startNode, int check) {
        Stack<Integer> stack = new Stack<>();
        visit[startNode] = true;
        stack.push(startNode);

        while (!stack.isEmpty()) {
            System.out.println("stack = " + stack);
            int x = stack.pop();
            System.out.println("x = " + x);
            for (int i=0; i<graph.get(x).size(); i++) {
                int y = subWord.indexOf(graph.get(x).get(i));
                if (check == y) return;
                if (!visit[y]) {
                    visit[y] = true;
                    stack.push(y);
                }
            }
            answer++;
            System.out.println("answer = " + answer);
        }
    }

    /**
     * 단어 변환 (https://programmers.co.kr/learn/courses/30/lessons/43163)
     * 
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public static int solution(String begin, String target, String[] words) {

        //target이 없을 경우 체크
        boolean bFlag = true;

        for (int i=0; i<words.length; i++) {
            subWord.add(words[i]);
            if (words[i].equals(target)) bFlag = false;
        }

        if (bFlag) return 0;

        subWord.add(begin);

        visit = new boolean[subWord.size()];

        System.out.println("subWord.toString()) = " + subWord.toString());

        //그래프
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

        System.out.println();
        System.out.println("subWord.indexOf(target) = " + subWord.indexOf(target));
        System.out.println();

        dfs(subWord.size()-1, subWord.indexOf(target));

        return answer+1;
    }
}