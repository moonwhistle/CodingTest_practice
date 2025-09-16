import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 참여자
        Map<String, Integer> participantMap = new HashMap<>();
        for (String par : participant) {
            participantMap.put(par, participantMap.getOrDefault(par, 0) + 1);
        }

        // 우승자
        Map<String, Integer> completionMap = new HashMap<>();
        for (String com : completion) {
            completionMap.put(com, completionMap.getOrDefault(com, 0) + 1);
        }

        // 참가자의 key 를 돌면서, completion 에 없거나 or count 가 더 적다면 그 사람이 범인
        for(String key : participantMap.keySet()) {
            if(!completionMap.containsKey(key)) {
                answer = key;
            } else if(participantMap.get(key) - completionMap.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }
}