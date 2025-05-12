class Solution {

    public static int solution(int[] wallet, int[] bill) {
        return foldBill(0, wallet, bill);
    }

    private static int foldBill(int cnt, int[] wallet, int[] bill) {
        if(isEnablePutMoney(wallet, bill[0], bill[1])) {
            return cnt;
        }

        if (bill[0] > bill[1]) {
            return foldBill(cnt+1, wallet, new int[] {bill[0] / 2, bill[1]});
        } else {
            return foldBill(cnt + 1, wallet, new int[] {bill[0], bill[1] / 2});
        }
    }

    private static boolean isEnablePutMoney(int[] wallet, int x, int y) {
        return (wallet[0] >= x && wallet[1] >= y) || (wallet[0] >= y && wallet[1] >= x);
    }
}
