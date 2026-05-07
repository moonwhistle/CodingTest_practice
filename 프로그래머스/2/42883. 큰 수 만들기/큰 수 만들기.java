import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(char num : number.toCharArray()) {
            int n = num - '0';
            
            while(!queue.isEmpty() && queue.peekLast() < n && k > 0) {
                queue.pollLast();
                k--;
            }
            
            queue.addLast(n);
        }
        
        while(k > 0) {
            queue.pollLast();
            k--;
        }
        
        while(!queue.isEmpty()) {
            answer += queue.pollFirst();
        }
        
        return answer;
    }
}