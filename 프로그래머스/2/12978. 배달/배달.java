import java.util.*;

class Solution {
    
    static int[] n;
    static ArrayList<int[]>[] info;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = new int[N + 1];
        info = new ArrayList[N + 1];
        Arrays.fill(n, Integer.MAX_VALUE);
        n[1] = 0;
        
        for(int i = 0 ; i <= N; i++) {
            info[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            int s = r[0];
            int e = r[1];
            int c = r[2];
            
            info[s].add(new int[]{e, c});
            info[e].add(new int[]{s, c});
        }
        
        dijkstra();
        
        for(int k : n) {
            if(k <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    private void dijkstra() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[] {1, 0});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int s = now[0];
            int c = now[1];
            
            for(int[] i : info[s]) {
                int e = i[0];
                int count = i[1];
                
                if(n[e] > count + c) {
                    n[e] = count + c;
                    queue.add(new int[]{e, count + c});
                }
            }
        }
    }
}