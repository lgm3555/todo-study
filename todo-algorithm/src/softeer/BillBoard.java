package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BillBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = Integer.parseInt(br.readLine());

        for (int i=0; i<check; i++) {
            int result = 0;
            String[] temp = br.readLine().split(" ");
            String a = trans(temp[0]);
            String b = trans(temp[1]);

            for (int j=0; j<5; j++) {
                boolean[] aFlag = numFlag(a.split("")[j]);
                boolean[] bFlag = numFlag(b.split("")[j]);

                for (int k=0; k<7; k++) {
                    if (aFlag[k] != bFlag[k]) {
                        result += 1;
                    }
                }
                //System.out.println(a.split("")[j] + "--" + b.split("")[j] + "--" + result);
            }

            System.out.println(result);
        }
    }

    private static boolean[] numFlag(String temp) {
        boolean[] flag = new boolean[7];
        switch (temp) {
            case "0":
                flag = new boolean[]{true, true, true, false, true, true, true};
                break;
            case "1":
                flag = new boolean[]{false, false, true, false, false, true, false};
                break;
            case "2":
                flag = new boolean[]{true, false, true, true, true, false, true};
                break;
            case "3":
                flag = new boolean[]{true, false, true, true, false, true, true};
                break;
            case "4":
                flag = new boolean[]{false, true, true, true, false, true, false};
                break;
            case "5":
                flag = new boolean[]{true, true, false, true, false, true, true};
                break;
            case "6":
                flag = new boolean[]{true, true, false, true, true, true, true};
                break;
            case "7":
                flag = new boolean[]{true, true, true, false, false, true, false};
                break;
            case "8":
                flag = new boolean[]{true, true, true, true, true, true, true};
                break;
            case "9":
                flag = new boolean[]{true, true, true, true, false, true, true};
                break;
            default:
                flag = new boolean[]{false, false, false, false, false, false, false};
        }

        return flag;
    }

    private static String trans(String temp) {
        String sum = "";
        if (temp.length() < 5) {
            for (int i=0; i<5-temp.length(); i++) {
                sum += "-";
            }
        }
        return sum + temp;
    }
}
