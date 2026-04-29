import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int x, int y, int n) {
        answer = Integer.MAX_VALUE;
        bfs(x, y, n);
        
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
    
    private void bfs(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{x, 0});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int cnt = now[1];
        
            if(num == y) {
                answer = Math.min(cnt, answer);
                continue;
            }
            
            if(num > y) {
                continue;
            }
            
            int[] nextValues = {
                num + n,
                num * 2,
                num * 3
            };

            for (int next : nextValues) {
                if (next <= y && !visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }
    }
}