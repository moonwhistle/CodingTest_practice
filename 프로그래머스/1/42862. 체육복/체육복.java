import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] count = new int[n + 1];
        Arrays.fill(count, 1);
        
        for(int e : lost) {
            count[e]--;
        }
        
        for(int e : reserve) {
            count[e]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(count[i] < 1) {
                if(i - 1 >= 1 && count[i - 1] > 1) {
                    count[i-1]--;
                    count[i]++;
                    continue;
                }
                
                if(i + 1 <= n && count[i + 1] > 1) {
                    count[i + 1]--;
                    count[i]++;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(count[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}