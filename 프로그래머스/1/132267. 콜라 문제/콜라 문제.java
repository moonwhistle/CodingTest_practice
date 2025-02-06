class Solution {

    public static int solution(int a, int b, int n) {
        int answer = 0;
        int init = n;

        while(init >= a) {
            int change = (init / a) * b;
            int remain = init % a;
            answer += change;
            init = change + remain;
        }
        
        return answer;
    }
}
