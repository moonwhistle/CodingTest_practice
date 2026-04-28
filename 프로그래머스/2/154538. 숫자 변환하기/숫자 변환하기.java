import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        dp[x] = 0;
        
        for(int i = x + 1; i < y + 1; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            
            if(i - n > 0 && dp[i-n] > -1) {
                a = dp[i -n];
            }
            
            if(i % 2 == 0) {
                if(i / 2 > -1 && dp[i / 2] > -1) {
                    b = dp[i / 2];
                }
            } 
            
            if(i % 3 == 0) {
                if(i / 3 > -1 && dp[i / 3] > -1) {
                c = dp[i / 3];
                }
            }
            
            
            
            if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE && c == Integer.MAX_VALUE ) {
                continue;
            }
            
            dp[i] = Math.min(a, Math.min(b, c)) + 1;
        }
        
        answer = dp[y];
        
        return answer;
    }
}