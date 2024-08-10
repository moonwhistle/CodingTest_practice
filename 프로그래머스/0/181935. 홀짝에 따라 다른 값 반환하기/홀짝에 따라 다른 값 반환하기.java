class Solution {
    public int solution(int n) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                oddSum += i;
            }
            else {
                evenSum += i*i;
            }
        }
        return n % 2 == 0 ? evenSum : oddSum;
    }
}