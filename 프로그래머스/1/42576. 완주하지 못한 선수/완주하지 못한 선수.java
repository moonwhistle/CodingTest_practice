import java.util.HashMap;
import java.util.Map;

class Solution {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> status = new HashMap<>();

        for(String person : participant) { // 참가자 수만큼 증가
            status.put(person, status.getOrDefault(person, 0) + 1);
        }

        for(String person : completion) { // 완주자 수만큼 감소
            status.put(person, status.getOrDefault(person, 0) - 1);
        }

        for(String person : status.keySet()) { // 해당 키를 순회하며 value 가 0이 아닌 사람을 탐색
            if(status.get(person) != 0) {
                answer = person;
            }
        }
        
        return answer;
    }
}
