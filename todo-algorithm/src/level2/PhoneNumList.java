package level2;

import java.util.Iterator;
import java.util.TreeSet;

public class PhoneNumList {
    public static void main(String[] args) {
        solution(new String[] {"119", "97674223", "1195524421"});
    }

    /**
     * 전화번호 목록 (https://school.programmers.co.kr/learn/courses/30/lessons/42577)
     *
     * @param phone_book
     * @return
     */
    public static boolean solution(String[] phone_book) {
        TreeSet<String> set = new TreeSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }

        //System.out.println(set);

        Iterator iter = set.iterator();
        String start = "";
        while (iter.hasNext()) {
            String temp = String.valueOf(iter.next());
            if (temp.length() >= start.length()) {
                if (!"".equals(start) && start.equals(temp.substring(0, start.length()))) {
                    return false;
                }
            }
            start = temp;
        }

        return true;
    }
}