import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = people.length;
        boolean[] visited = new boolean[l];
        int second = 0;
        
        for(int i = l - 1; i >= 0; i--) {
            if(visited[i]) {
                break;
            }
            
            int sum = people[i];
            
            if(sum + people[second] <= limit) {
                visited[second] = true;
                second++;
            }
            
            answer++;
        }
        
        return answer;
    }
}