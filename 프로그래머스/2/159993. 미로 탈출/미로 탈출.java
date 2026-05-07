import java.util.*;

class Solution {
    
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int row;
    static int col;
    static char[][] map;
    static int[] start;
    static int[] end;
    static int[] l;
    static boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        row = maps[0].length();
        col = maps.length;
        
        map = new char[col][row];
        makeMap(maps);
        
        // 레버 찾기
        answer += bfs(start, l);
        
        if(answer == 0) {
            return -1;
        }
        
        int findEnd = bfs(l, end);
        
        if(findEnd == 0) {
            return -1;
        }
        
        answer += findEnd;
        
        return answer;
    }
    
    private static int bfs(int[] s, int[] target) {
        int count = 0;
        visited = new boolean[col][row];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {s[0], s[1], 0});
        visited[s[0]][s[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int ny = now[0];
            int nx = now[1];
            int c = now[2];
            
            if(ny == target[0] && nx == target[1]) {
                return c;
            }
            
            for(int i = 0; i < 4; i++) {
                int nny = ny + dy[i];
                int nnx = nx + dx[i];
                
                if(nny < 0 || nny >= col || nnx < 0 || nnx >= row) {
                    continue;
                }
                
                if(visited[nny][nnx]) {
                    continue;
                }
                
                if(map[nny][nnx] == 'X') {
                    continue;
                }
                
                queue.add(new int[] {nny, nnx, c + 1});
                visited[nny][nnx] = true;
            }
        }
        
        return count;
    }
    
    private static void makeMap(String[] maps) {
        int y = 0;
        
        for(String ma : maps) {
            for(int x = 0 ; x < row; x++) {
                map[y][x] = ma.charAt(x);
                
                if(map[y][x] == 'S') {
                    start = new int[]{y, x};
                }
                
                if(map[y][x] == 'E') {
                    end = new int[]{y, x};
                }
                
                if(map[y][x] == 'L') {
                    l = new int[]{y, x};
                }
            }
            
            y++;
        }
    }
    
    
}