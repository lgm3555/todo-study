package level1;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonalInfoPeriod {
    public static void main(String[] args) {
        solution("2022.05.19", new String[] {"A 6", "B 12", "C 3"}, new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }

    /**
     * 개인정보 수집 유효 기간 (https://school.programmers.co.kr/learn/courses/30/lessons/150370)
     *
     * @param today
     * @param terms
     * @param privacies
     * @return
     */
    public static int[] solution(String today, String[] terms, String[] privacies) {
        String[] splitToday = today.split("\\.");
        int todayY = Integer.parseInt(splitToday[0]);
        int todayM = Integer.parseInt(splitToday[1]);
        int todayD = Integer.parseInt(splitToday[2]);

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        //System.out.println(termMap);

        for (int i=0; i<privacies.length; i++) {
            String[] splitPrivacie = privacies[i].split(" ");
            int month = termMap.get(splitPrivacie[1]);
            String[] splitPrivacieDate = splitPrivacie[0].split("\\.");

            int privacieY = Integer.parseInt(splitPrivacieDate[0]);
            int privacieM = Integer.parseInt(splitPrivacieDate[1]) + month;
            int privacieD = Integer.parseInt(splitPrivacieDate[2]);

            if (privacieM > 12) {
                if (privacieM % 12 == 0) {
                    privacieY = privacieY + (privacieM / 12) - 1;
                    privacieM = 12;
                } else {
                    privacieY = privacieY + (privacieM / 12);
                    privacieM = privacieM % 12;
                }
            }

            System.out.println(privacieY + "." + privacieM + "." + privacieD);

            if (todayY > privacieY) {
                answer.add(i+1);
            } else if (todayY == privacieY) {
                if (todayM > privacieM) {
                    answer.add(i+1);
                } else if (todayM == privacieM) {
                    if (todayD >= privacieD) {
                        answer.add(i+1);
                    }
                }
            }
        }

        int[] result = new int[answer.size()];
        for (int a=0; a<answer.size(); a++) {
            result[a] = answer.get(a);
        }

        //return new int[3];
        return result;
    }
}
