package level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO 공부
public class NExpression {
    public static void main(String[] args) {
        NExpression nExpression = new NExpression();
        nExpression.solution(5, 12);
    }

    /**
     * N으로 표현 (https://school.programmers.co.kr/learn/courses/30/lessons/42895)
     *
     * @param N
     * @param number
     * @return
     */
    public int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();

        for(int i=0; i<9; i++)
            countList.add(new HashSet<>());

        countList.get(1).add(N); // N을 1개 쓴 값은 N 혼자이다.

        for(int i=2; i<9; i++){
            Set<Integer> countSet = countList.get(i);

            for(int j=1; j<=i; j++){
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);

                System.out.println(j + " - preSet = " + preSet);
                System.out.println((i-j) + " - postSet = " + postSet);

                for(int preNum : preSet){
                    for(int postNum : postSet){
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if(preNum != 0 && postNum != 0)
                            countSet.add(preNum / postNum);
                    }
                }
            }

            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for(Set<Integer> sub : countList){
            if(sub.contains(number))
                return countList.indexOf(sub);
        }

        return -1;
    }
}