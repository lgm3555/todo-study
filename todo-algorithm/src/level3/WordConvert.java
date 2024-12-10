package level3;

import java.lang.reflect.Array;
import java.util.*;

public class WordConvert {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot","dot","dog","lot","log","cog"}));
        /**
         * hit -> hot, lot
         *
         * hot -> dot, lot
         * dot -> hot, lot, dog
         * dog -> dot, log, cog
         * lot -> hot, dot, log
         * log -> dog, lot, cog
         * cog
         */
    }

    /**
     * 단어 변환 (https://programmers.co.kr/learn/courses/30/lessons/43163)
     * 
     * @param begin
     * @param target
     * @param words
     * @return
     */
    private static final ArrayList<ArrayList<String>> graph = new ArrayList<>();
    private static final HashMap<String, Integer> index = new HashMap<>();
    public static int solution(String begin, String target, String[] words) {
        int result = Integer.MAX_VALUE;
        boolean bFlag = true;

        for (int i=0; i<words.length; i++) {
            index.put(words[i], i);
            graph.add(checkWord(words[i], words));
            if (target.equals(words[i])) bFlag = false;
        }

        if (bFlag) return 0;

        //System.out.println("index = " + index);
        //System.out.println("graph = " + graph);

        ArrayList<String> startList = checkWord(begin, words);
        for (String temp : startList) {
            boolean[] visited = new boolean[words.length];
            result = Math.min(result, revert(temp, target, visited, 1));
        }

        System.out.println("result = " + result);

        return result;
    }

    private static int revert(String now, String target, boolean[] visited, int answer) {
        if (now.equals(target)) return answer;

        ArrayList<String> tempList = graph.get(index.get(now));
        int minStep = Integer.MAX_VALUE;

        for (String temp : tempList) {
            int nextIndex = index.get(temp);
            if (!visited[nextIndex]) {
                visited[nextIndex] = true;
                minStep = revert(temp, target, visited, answer+1);
                visited[nextIndex] = false;
            }
        }
        return minStep;
    }

    private static ArrayList<String> checkWord(String word, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        char[] a = word.toCharArray();

        for (int j=0; j<words.length; j++) {
            int flag = 0;
            char[] b = words[j].toCharArray();

            for (int k=0; k<word.length(); k++) {
                if (a[k] != b[k]) flag++;
            }

            if (flag == 1) list.add(words[j]);
        }
        return list;
    }
}