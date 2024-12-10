package level1;

import java.util.HashSet;

public class Pokemon {
    public static void main(String[] args) {
        solution(new int[] {3,1,2,3});
    }

    /**
     * 폰캣몬 (https://school.programmers.co.kr/learn/courses/30/lessons/1845)
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int k = nums.length/2;

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() >= k) {
            return k;
        } else {
            return set.size();
        }
    }
}
