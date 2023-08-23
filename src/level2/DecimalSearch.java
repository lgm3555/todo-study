package level2;

import java.util.HashSet;
import java.util.Iterator;

//TODO 풀이중
public class DecimalSearch {
    public static void main(String[] args) {
        DecimalSearch decimalSearch = new DecimalSearch();
        decimalSearch.solution("17");
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

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();

            boolean flag = true;
            for (int i=2; i<=Math.sqrt(temp); i++) {
                if (temp % i == 0) {
                    flag = false;
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(String temp, String n) {
        if (!temp.equals("")) {
            if (Integer.parseInt(temp) > 1) {
                set.add(Integer.parseInt(temp));
            }
        }

        for (int i=0; i<n.length(); i++) {
            dfs(temp + n.charAt(i), n.substring(0, i) + n.substring(i + 1));
        }
    }
}
