class Solution {

    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        if (answer == 0) {
            answer = n - 1;
        }
        return answer;
    }
}
