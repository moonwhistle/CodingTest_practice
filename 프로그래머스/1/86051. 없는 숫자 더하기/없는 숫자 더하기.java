class Solution {

    static boolean[] exists = new boolean[10];

    public static int solution(int[] numbers) {
        int answer = 0;

        for(int i : numbers) {
            exists[i] = true;
        }

        for(int i = 0 ; i<= 9; i++) {
            if(!exists[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}
