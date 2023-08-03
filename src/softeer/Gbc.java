package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gbc {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int n = Integer.parseInt(mn[0]);

        int result = 0;
        String temp = "";
        int nSum = 0;
        int mSum = 0;
        int num = 0;
        int flag = 0;
        HashMap<Integer, Integer> nMap = new HashMap<>();
        ArrayList<Integer> nList = new ArrayList<>();
        while ((temp = br.readLine()) != null) {
            String[] tempArr = temp.split(" ");
            if (num < n) {
                nSum += Integer.parseInt(tempArr[0]);
                nList.add(nSum);
                nMap.put(nSum, Integer.parseInt(tempArr[1]));
            } else {
                mSum += Integer.parseInt(tempArr[0]);

                for (int i=0; i<nList.size(); i++) {
                    if (nList.get(i) > flag) {
                        // 측정길이가 기준길이보다 클 경우
                        if (mSum > nList.get(i)) {
                            // 측정속도가 기준속도보다 클 경우
                            if (Integer.parseInt(tempArr[1]) > nMap.get(nList.get(i))) {
                                int tempResult = Integer.parseInt(tempArr[1]) - nMap.get(nList.get(i));
                                // 이전 속도보다 더 클 경우에만 담기
                                if (result < tempResult) {
                                    result = tempResult;
                                }
                            }
                        } else { //기준길이가 측정길이보다 클 경우
                            //한번 측정하고 for문 나가야함.
                            // 측정속도가 기준속도보다 클 경우
                            if (Integer.parseInt(tempArr[1]) > nMap.get(nList.get(i))) {
                                int tempResult = Integer.parseInt(tempArr[1]) - nMap.get(nList.get(i));
                                // 이전 속도보다 더 클 경우에만 담기
                                if (result < tempResult) {
                                    result = tempResult;
                                }
                            }
                            break;
                        }
                    }
                }
                flag = mSum;
            }
            num++;
        }
        System.out.println(result);
    }

    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int max = 0;
        Map<Integer, Integer> limitMap = new TreeMap<>();
        int currentHeight = 0;
        for (int i = 0; i < n; i++) {
            String[] heightAndLimit = sc.nextLine().split(" ");
            currentHeight += Integer.parseInt(heightAndLimit[0]);
            limitMap.put(currentHeight, Integer.parseInt(heightAndLimit[1]));
        }

        int currentStart = 0;
        int currentEnd = 0;
        for (int i = 0; i < m; i++) {
            String[] heightAndLimit = sc.nextLine().split(" ");
            int paramH = Integer.parseInt(heightAndLimit[0]);
            int paramL = Integer.parseInt(heightAndLimit[1]);

            currentStart = currentEnd;
            currentEnd += paramH;

            int start = 0;
            int end = 0;
            for (int height : limitMap.keySet()) {
                start = end;
                end = height;

                if (end > currentStart && start < currentEnd) {
                    if (limitMap.get(height) < paramL) {
                        max = Math.max(max, paramL - limitMap.get(height));
                    }
                }
            }
        }
        System.out.println(max);
    }
}
