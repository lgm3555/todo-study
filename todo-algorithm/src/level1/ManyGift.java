package level1;

import java.util.HashMap;

public class ManyGift {
    public static void main(String[] args) {
        solution(new String[] {"muzi", "ryan", "frodo", "neo"}, new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
    }

    /**
     * 가장 많이 받은 선물 (https://school.programmers.co.kr/learn/courses/30/lessons/258712)
     *
     * @param friends
     * @param gifts
     * @return
     */
    public static int solution(String[] friends, String[] gifts) {
        HashMap<String, HashMap<String, Integer>> tMap = new HashMap<>();
        HashMap<String, Integer> gCnt = new HashMap<>(); //줌
        HashMap<String, Integer> rCnt = new HashMap<>(); //받음

        for (String friend : friends) {
            HashMap<String, Integer> tempMap = new HashMap<>();
            tMap.put(friend, tempMap);
            gCnt.put(friend, 0);
            rCnt.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] splitGift = gift.split(" ");
            HashMap<String, Integer> tempMap = tMap.get(splitGift[0]);
            tempMap.put(splitGift[1], tempMap.getOrDefault(splitGift[1], 0) + 1);
            tMap.put(splitGift[0], tempMap);
            gCnt.put(splitGift[0], gCnt.get(splitGift[0]) + 1);
            rCnt.put(splitGift[1], rCnt.get(splitGift[1]) + 1);
        }

        //System.out.println(tMap);
        //System.out.println(gCnt);
        //System.out.println(rCnt);

        HashMap<String, Integer> result = new HashMap<>();

        for (String key : tMap.keySet()) {
            for (String subKey : tMap.keySet()) {
                if (key.equals(subKey)) {
                    continue;
                }
                int a = tMap.get(key).get(subKey) == null ? 0 : tMap.get(key).get(subKey);
                int b = tMap.get(subKey).get(key) == null ? 0 : tMap.get(subKey).get(key);

                if (a > b) {
                    result.put(key, result.getOrDefault(key, 0) + 1);
                } else if (a < b) {
                    result.put(subKey, result.getOrDefault(subKey, 0) + 1);
                } else {
                    //선물 주고받지 않거나 같음
                    int c = gCnt.get(key) - rCnt.get(key);
                    int d = gCnt.get(subKey) - rCnt.get(subKey);

                    if (c > d) {
                        result.put(key, result.getOrDefault(key, 0) + 1);
                    } else if (c < d) {
                        result.put(subKey, result.getOrDefault(subKey, 0) + 1);
                    }
                }
            }
        }

        System.out.println(result);
        int answer = 0;
        for (String key : result.keySet()) {
            if (answer < result.get(key)) {
                answer = result.get(key);
            }
        }

        return answer / 2;
    }
}
