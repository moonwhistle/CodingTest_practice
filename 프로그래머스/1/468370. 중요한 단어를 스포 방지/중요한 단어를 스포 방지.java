import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        Set<String> box = new HashSet<>();
        String[] words = message.split(" ");
        int[] masking = new int[words.length];
        int cur = 0;
        int idx = 0;
        
        for(String word : words) {
            int s = cur;
            int e = cur + word.length() - 1;
            
            for(int[] spoiler : spoiler_ranges) {
                if(spoiler[0] <= e && spoiler[1] >= s) {
                    masking[idx] = 1;
                    break;
                }
            }
            
            if(masking[idx] == 0) {
                box.add(word);
            }
            
            cur += word.length() + 1;
            idx++;
        }
        
        Set<String> result = new HashSet<>();
        
        for(int i = 0 ; i < masking.length; i++) {
            if(masking[i] == 1 && !box.contains(words[i]) && !result.contains(words[i])) {
                result.add(words[i]);
                answer++;
            } 
        }
        
        return answer;
    }
}