import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranks = new HashMap<>();
        
        for(int i = 0 ; i < players.length ; i ++) {
            ranks.put(players[i], i);
        }
        
        for(String call : callings) {
            int nowRank = ranks.get(call);
            
            String current = players[nowRank];
            String prev = players[nowRank - 1];
            
            players[nowRank - 1] = current;
            players[nowRank] = prev;
            
            ranks.put(current, nowRank - 1);
            ranks.put(prev, nowRank);
        }
        
        return players;
    }
}