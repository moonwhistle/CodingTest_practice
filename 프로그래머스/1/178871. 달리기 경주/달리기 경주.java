import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> order = new HashMap<>(); // 순위별 선수
        Map<String, Integer> py = new HashMap<>(); // 선수별 순위
        
        for(int i = 0 ; i < players.length; i++) {
            int o = i + 1;
            String player = players[i];
            
            order.put(o, player);
            py.put(player, o);
        }
        
        for(String call : callings) {
            int nowOrder = py.get(call);
            String originalPlayer = order.get(nowOrder - 1);
            
            py.put(call, nowOrder - 1);
            py.put(originalPlayer, nowOrder);
            
            order.put(nowOrder, originalPlayer);
            order.put(nowOrder - 1, call);
        }
        
        String[] answer = new String[players.length];
        
        for(int i = 0 ; i < players.length; i++) {
            answer[i] = order.get(i + 1);
        }
        
        return answer;
    }
}