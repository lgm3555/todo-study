package level2;

import java.util.HashSet;

//TODO 풀이중
public class DecimalSearch {
    public static void main(String[] args) {
        DecimalSearch decimalSearch = new DecimalSearch();
        decimalSearch.solution("011");
    }

    /**
     * 소수 찾기 (https://school.programmers.co.kr/learn/courses/30/lessons/42839)
     *
     * @param numbers
     * @return
     */
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        dfs("", numbers);

        return answer;
    }

    private void dfs(String temp, String n) {
        if (!temp.equals("")) {
            set.add(Integer.parseInt(temp));
        }

        for (int i=0; i<n.length(); i++) {
            dfs(temp + n.charAt(i), n.substring(0, i) + n.substring(i + 1));
        }
    }
}
