import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps);
        if(maps[maps.length-1][maps[0].length-1] == 1) {
            return -1;
        } else {
            return maps[maps.length-1][maps[0].length-1];
        }
    }

    public void bfs(int[][] maps) {
        Queue<int[]> index = new LinkedList<>();
        index.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!index.isEmpty()) {
            int[] now = index.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
                    if (!visited[x][y] && maps[x][y] == 1) {
                        visited[x][y] = true;
                        index.add(new int[]{x, y});
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}