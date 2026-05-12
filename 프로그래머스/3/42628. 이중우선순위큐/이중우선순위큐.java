import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> o = new PriorityQueue<>();
        PriorityQueue<Integer> ro = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> oDelete = new HashMap<>();
        Map<Integer, Integer> roDelete = new HashMap<>();
        
        for(String operation : operations) {
            String[] command = operation.split(" ");
            String com = command[0];
            int num = Integer.parseInt(command[1]);
            
            if(com.equals("I")) {
                o.add(num);
                ro.add(num);
                continue;
            }
            
            clean(o, roDelete);
            clean(ro, oDelete);
            
            if(com.equals("D") && num == 1) {
                if(ro.isEmpty()) {
                    continue;
                }
                
                int n = ro.poll();
                roDelete.put(n, roDelete.getOrDefault(n, 0) + 1);
                continue;
            }
            
            if(com.equals("D") && num == -1) {           
                if(o.isEmpty()) {
                    continue;
                }
                
                int n = o.poll();
                oDelete.put(n, oDelete.getOrDefault(n, 0) + 1);
            }
        }
        
        clean(o, roDelete);
        clean(ro, oDelete);
        
        if(o.isEmpty()) {
            return new int[] {0, 0};
        }
        
        answer[0] = ro.poll();
        answer[1] = o.poll();
        
        return answer;
    }
    
    private static void clean(PriorityQueue<Integer> pq, Map<Integer, Integer> delete) {
        while(!pq.isEmpty()) {
            int n = pq.peek();
            
            if(!delete.containsKey(n)) {
                return;
            }
            
            int count = delete.get(n);
            pq.poll();
            count--;
                
            if(count == 0) {
                delete.remove(n);
            } else {
                delete.put(n, count);
            }
        }
    }
}