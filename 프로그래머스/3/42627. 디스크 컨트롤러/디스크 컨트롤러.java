import java.util.*;

class Solution {
    
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(n -> n[0]));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int time = 0;
        int idx = 0;
        int count = 0;
        
        while(count < jobs.length) {
            while(idx < jobs.length && time >= jobs[idx][0]) {
                int[] job = jobs[idx];
                pq.add(new Node(idx , job[0], job[1]));
                idx++;
            }
            
            if(pq.isEmpty()) {
                time++;
                continue;
            }
            
            Node node = pq.poll();
            count++;
            
            time += node.l;
            answer += (time - node.s);
        }
        
        return answer / jobs.length;
    }
}

class Node implements Comparable<Node>{
    
    int v;
    int s;
    int l;
    
    public Node(int v, int s, int l) {
        this.v = v;
        this.s = s;
        this.l = l;
    }
    
    @Override
    public int compareTo(Node other) {
        if(l == other.l) {
            if(s == other.s) {
                return v - other.v;
            }
            
            return s - other.s;
        }
        
        return l - other.l;
    }
}