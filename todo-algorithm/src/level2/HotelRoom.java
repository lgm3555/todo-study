package level2;

import java.util.*;

public class HotelRoom {

    public static void main(String[] args) {
        //solution(new String[][] {{"09:00", "16:00"}, {"10:00", "11:00"}, {"10:00", "13:00"}, {"15:10", "18:50"}}); //2
        solution(new String[][] {{"1:00", "2:01"}, {"2:10", "3:00"}, {"3:10", "4:00"}});
    }

    private static boolean[] flag;
    public static int solution(String[][] book_time) {
        int answer = 0;
        flag = new boolean[book_time.length];
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        System.out.println("book_time = " + Arrays.deepToString(book_time));

        int endSum = Integer.parseInt(book_time[0][1].split(":")[0]) * 60 + Integer.parseInt(book_time[0][1].split(":")[1]);

        for (int i=0; i<flag.length; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            answer++;
            retry(endSum, book_time, i);
        }

        System.out.println("answer = " + answer);

        return answer;
    }

    private static void retry(int endSum, String[][] book_time, int index) {
        for (int i=index+1; i<book_time.length; i++) {
            if (flag[i]) continue;
            int aSum = Integer.parseInt(book_time[i][0].split(":")[0]) * 60 + Integer.parseInt(book_time[i][0].split(":")[1]);
            int bSum = Integer.parseInt(book_time[i][1].split(":")[0]) * 60 + Integer.parseInt(book_time[i][1].split(":")[1]);

            if (endSum + 10 <= aSum) {
                flag[i] = true;
                endSum = bSum;
            }

            //System.out.println("flag = " + Arrays.toString(flag));
        }
    }
}
