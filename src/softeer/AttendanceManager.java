package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AttendanceManager {

    public static void main(String args[])  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int sumA = 0;
        int sumB = 0;
        while ((line = br.readLine()) != null) {
            String[] timeArr = line.split(" ");
            sumA += Integer.parseInt(timeArr[0].split(":")[0]) * 60 + Integer.parseInt(timeArr[0].split(":")[1]);
            sumB += Integer.parseInt(timeArr[1].split(":")[0]) * 60 + Integer.parseInt(timeArr[1].split(":")[1]);
        }

        System.out.println(sumB - sumA);
    }
}
