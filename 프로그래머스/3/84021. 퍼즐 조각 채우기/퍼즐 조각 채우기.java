import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static boolean[][] visited;
    static List<List<Point>> points;
    static int answer;
    static boolean[] isUsed;
    
    public static int solution(int[][] game_board, int[][] table) {
        answer = 0;
        points = new ArrayList<>();
        getPoints(table, 1, 0);
        isUsed = new boolean[points.size()];
        getPoints(game_board, 0, 1);
        
        return answer;
    }
    
    private static void rotate(List<Point> point) {
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        
        for(Point p : point) {
            int tmp = p.x;
            p.x = -p.y;
            p.y = tmp;
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        
        for(Point p : point) {
            p.close(minY, minX);
        }
    }
    
    private static void getPoints(int[][] map, int f, int mode) {
        int n = map.length;
        visited = new boolean[n][n];
        
        for(int y = 0; y < n; y++) {
            for(int x = 0 ; x < n; x++) {
                if(!visited[y][x] && map[y][x] == f) {
                    // bfs
                    List<Point> p = bfs(y, x, map, f);
                    
                    if(mode == 0) {
                        points.add(p);
                    }
                    
                    if(mode == 1) {
                        boolean isMatch = false;
                        
                        for(int i = 0 ; i < points.size(); i++) {
                            List<Point> po = points.get(i);
                            
                            // 사용된 부분
                            if(isUsed[i]) {
                                continue;
                            }
                            
                            // 넓이 다른 경우
                            if(po.size() != p.size()) {
                                continue;
                            }
                            
                            // 회전 4번
                            for(int j = 0 ; j < 4; j++) {
                                rotate(po);
                                
                                if(p.containsAll(po)) {
                                    isUsed[i] = true;
                                    answer += p.size();
                                    isMatch = true;
                                    break;
                                }
                            }
                            
                            if(isMatch) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static List<Point> bfs(int y, int x, int[][] map, int f) {
        int n = map.length;
        List<Point> list = new ArrayList<>();
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        Point po = new Point(y, x);
        queue.add(po);
        list.add(po);
        visited[y][x] = true;
        minY = Math.min(minY, y);
        minX = Math.min(minX, x);
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            
            for(int i = 0 ; i < 4 ; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if(ny >=0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]) {
                    if(map[ny][nx] == f) {
                        visited[ny][nx] = true;
                        minY = Math.min(minY, ny);
                        minX = Math.min(minX, nx);
                        Point p = new Point(ny, nx);
                        queue.add(p);
                        list.add(p);
                    }
                }
            }
        }
        
        // list 최적화
        for(Point p : list) {
            p.close(minY, minX);
        }
        
        return list;
    }
}

class Point {
    
    int y;
    int x;
    
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
    
    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        
        if(!(other instanceof Point)) {
            return false;
        }
        
        Point p = (Point) other;
        
        return y == p.y && x == p.x;
    }
    
    // 벽으로 붙이기
    public void close(int minY, int minX) {
        this.y -= minY;
        this.x -= minX;
    }
}