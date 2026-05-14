import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = people.length -1;
        int j = 0;
        
        for(int i = l ; i >= 0; i--) {
            if(i == j) {
                answer++;
                break;
            }
            
            if(j > i) {
                break;
            }
            
            if(people[i] + people[j] <= limit) {
                j++;
            }
            
            answer++;
        }
        
        return answer;
    }
}