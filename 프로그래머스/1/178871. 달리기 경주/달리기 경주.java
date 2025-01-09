import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        Map<String, Integer> rank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String call : callings) {
            int ranking = rank.get(call);

            String prev = players[ranking - 1];
            String current = players[ranking];

            players[ranking] = prev;
            players[ranking - 1] = current;

            rank.put(prev, ranking);
            rank.put(current, ranking - 1);
        }
        
        answer = players;
        return answer;
    }
}