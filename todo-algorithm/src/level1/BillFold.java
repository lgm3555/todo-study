package level1;

public class BillFold {
    public static void main(String[] args) {
        solution(new int[] {30, 15}, new int[] {26, 17});
    }

    /**
     * 지폐 접기 (https://school.programmers.co.kr/learn/courses/30/lessons/340199)
     *
     * @param wallet
     * @param bill
     * @return
     */
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int maxWallet = wallet[0];
        int minWallet = wallet[1];
        int maxBill = bill[0];
        int minBill = bill[1];

        if (wallet[0] < wallet[1]) {
            minWallet = wallet[0];
            maxWallet = wallet[1];
        }

        if (bill[0] < bill[1]) {
            minBill = bill[0];
            maxBill = bill[1];
        }

        while (true) {
            if (minBill > minWallet || maxBill > maxWallet) {
                int temp = maxBill / 2;

                if (temp < minBill) {
                    maxBill = minBill;
                    minBill = temp;
                } else {
                    maxBill = temp;
                }
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
