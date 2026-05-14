import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<Node> pq = new ArrayList<>();
        int ii = 0;
        int time = 0;
        
        for(int[] job : jobs) {
            pq.add(new Node(ii, job[0], job[1]));
            ii++;
        }
        
        PriorityQueue<Node> process = new PriorityQueue<>();
        
        while(!pq.isEmpty() || !process.isEmpty()) {
            int idx = -1;
            Map<Integer, Integer> index = new HashMap<>();
            PriorityQueue<Node> order = new PriorityQueue<>();
            
            for(int i = 0 ; i < pq.size(); i++) {
                Node now = pq.get(i);
                
                if(now.start <= time && process.isEmpty()) { // 작업할거 넣기
                    order.add(now);
                    index.put(now.id, i);
                }
            }
            
            if(!order.isEmpty()) {
                Node in = order.poll();
                process.add(in);
                idx = index.get(in.id);
            }
            
            if(idx != -1) {
                pq.remove(idx);
            }
            
            time++;
            
            if(!process.isEmpty()) {
                Node pro = process.poll();
                pro.count++;
                
                if(pro.count == pro.length) {
                    answer += (time - pro.start);
                } else {
                    process.add(pro);
                }
            }
        }
        
        return answer / jobs.length;
    }
}

class Node implements Comparable<Node>{
    
    int id;
    int start;
    int length;
    int count;
    
    public Node(int id, int start, int length) {
        this.id = id;
        this.start = start;
        this.length = length;
        this.count = 0;
    }
    
    @Override
    public int compareTo(Node other) {
        if(length == other.length) {
            if(start == other.start) {
                return id - other.id;
            }
            
            return start - other.start;
        }
        
        return length - other.length;
    }
}