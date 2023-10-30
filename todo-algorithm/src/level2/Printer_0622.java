package level2;

import java.util.*;

public class Printer_0622 {


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 7, 9, 1, 1, 1}, 0));
    }

    /**
     * 프린터 Solution (https://programmers.co.kr/learn/courses/30/lessons/42587)
     *
     * @param priorities 우선순위
     * @param location 요청한 문서 순위
     * @return
     */
    public static int solution(int[] priorities, int location) {
        Queue<HashMap<Integer, Integer>> q1 = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<priorities.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(i, priorities[i]);
            q1.add(map);

            list.add(priorities[i]);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i=0; i<list.size(); i++) {
            for (int j=0; j <q1.size(); j++) {
                if (q1.peek().containsValue(list.get(i))) {
                    if (q1.peek().containsKey(location)) {
                        return i+1;
                    } else {
                        q1.poll();
                    }
                    break;
                } else {
                    q1.add(q1.poll());
                }
            }
        }

        return 0;
    }

}
