import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        //세팅
        Arrays.sort(score);
        List<Integer> apple = new ArrayList<>();

        //로직
        for(int i = score.length -1 ; i>=0; i--) {
            if(score[i] <= k){
                apple.add(score[i]);
            }

            if(apple.size() == m) {
                answer += apple.get(m-1) * m;
                apple = new ArrayList<>();
            }
        }
        
        return answer;
    }
}
