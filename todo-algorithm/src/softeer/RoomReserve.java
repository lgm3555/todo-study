package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RoomReserve {
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        TreeMap<String, ArrayList<String>> room = new TreeMap<>();

        String temp = "";
        int i = 0;
        while ((temp = br.readLine()) != null) {
            if (m > i) {
                room.put(temp, new ArrayList<>());
            } else {
                String[] tempArr = temp.split(" ");
                ArrayList<String> list = room.get(tempArr[0]);
                list.add(tempArr[1] + " " + tempArr[2]);
            }
            i++;
        }

        room.size();

        Iterator<String> iterator = room.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            ArrayList<String> value = room.get(key);

            Collections.sort(value);

            System.out.println("Room " + key + ":");

            int start = 9;
            int finish = 18;

            for (int k=0; k<value.size(); k++) {
                String[] sf = (value.get(k)).split(" ");

                if (Integer.parseInt(sf[0]) == start) {
                    start = Integer.parseInt(sf[1]);
                } else {
                    start = Integer.parseInt(sf[0]);
                }

                if (Integer.parseInt(sf[1]) == finish) {
                    finish = Integer.parseInt(sf[1]);
                } else {
                    finish = Integer.parseInt(sf[1]);
                }

                if (start != finish) {
                    System.out.println(start + " " + finish);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        TreeMap<String, ArrayList<Integer>> room = new TreeMap<>();

        String temp = "";
        int i = 0;
        while ((temp = br.readLine()) != null) {
            if (m > i) {
                room.put(temp, new ArrayList<>());
            } else {
                String[] tempArr = temp.split(" ");
                ArrayList<Integer> list = room.get(tempArr[0]);
                list.add(Integer.parseInt(tempArr[1]));
                list.add(Integer.parseInt(tempArr[2]));
            }
            i++;
        }

        Iterator<String> iterator = room.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();

            System.out.println("Room " + key + ":");

            ArrayList<Integer> list = room.get(key);

            if (list.size() > 0) {

                int start = list.get(0) == 9 ? list.get(1) : 9;
                int finish = 0;

                for (int j=1; j<list.size()-1; j++) {
                    ArrayList<String> time = new ArrayList<>();
                    for (int k=9; k<19; k++) {
                        if (list.get(j) == k) {
                            finish = k;

                            break;
                        } else {
                            if (start > k) {
                                start = k;
                            }
                        }
                    }
                    System.out.println(time);
                }


            } else {
                System.out.println("Not available");
            }

            System.out.println("-----");
        }
    }
}