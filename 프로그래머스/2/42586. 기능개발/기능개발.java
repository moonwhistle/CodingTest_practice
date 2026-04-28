import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        int count = 0;
        
        while(idx < speeds.length) {
            int cnt = 0;
            
            while(idx < speeds.length && progresses[idx] + (speeds[idx] * count) >= 100) {
                idx++;
                cnt++;
            }
            
            if(cnt != 0) {
                answer.add(cnt);
            }
            
            count++;
        }
        
        return answer.stream()
            .mapToInt(n -> n)
            .toArray();
    }
}