class Solution {

    public static long solution(int price, int money, int count) {
        long sum = 0;

        for (long i = 1; i <= count; i++) {
            sum += price * i;
        }
        
        if(sum <= money) {
            return 0;
        }

        return sum - money;
    }
}
