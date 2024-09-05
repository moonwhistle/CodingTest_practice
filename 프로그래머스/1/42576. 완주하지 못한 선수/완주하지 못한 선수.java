import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
         Map<String, Integer> member = new HashMap<>();
        for(String name : participant){
            member.put(name, member.getOrDefault(name, 0) + 1);
        }
        for(String name : completion){
            member.put(name, member.getOrDefault(name, 0) - 1);
        }
        String answer = "";
        for(String name : member.keySet()){
            if(member.get(name) != 0) {
                answer = name;
            }
        }
        return answer;
    }
}