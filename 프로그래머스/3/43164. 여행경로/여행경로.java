import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    
    public static String[] solution(String[][] tickets) {
        String[] answer;
        //세팅
        Map<String, PriorityQueue<String>> pair = new HashMap<>();
        for (String[] t : tickets) {
            String start = t[0];
            String end = t[1];
            pair.putIfAbsent(start, new PriorityQueue<>());
            pair.get(start).add(end);
        }

        System.out.println(pair);

        List<String> connect = new ArrayList<>();
        dfs(pair, "ICN", connect);

        System.out.println(connect);

        answer = new String[connect.size()];
        for(int i = 0; i<connect.size(); i++) {
            answer[i] = connect.get(i);
        }

        return answer;
    }

    private static void dfs(Map<String, PriorityQueue<String>> pair, String start, List<String> connect) {
        while(pair.containsKey(start) && !pair.get(start).isEmpty()) {
            String end = pair.get(start).poll();
            dfs(pair, end, connect);
        }
        connect.add(0, start);
    }
}
