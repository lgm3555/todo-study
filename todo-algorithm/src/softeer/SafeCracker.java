package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class SafeCracker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wn = br.readLine().split(" ");
        int w = Integer.parseInt(wn[0]);
        int n = Integer.parseInt(wn[1]);

        Comparator<Integer> comparator = Comparator.reverseOrder();
        TreeMap<Integer, Integer> map = new TreeMap<>(comparator);
        String temp = "";
        while ((temp = br.readLine()) != null) {
            map.put(Integer.parseInt(temp.split(" ")[1]), map.getOrDefault(Integer.parseInt(temp.split(" ")[1]), 0) + Integer.parseInt(temp.split(" ")[0]));
        }

        int result = 0;

        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            if (w == 0) break;

            int key = iterator.next();
            int value = map.get(key);

            if (w > value) {
                w = w - value;
                result = result + (value * key);
            } else {
                result = result + (w * key);
                w = 0;
            }
        }

        System.out.println(result);
    }
}