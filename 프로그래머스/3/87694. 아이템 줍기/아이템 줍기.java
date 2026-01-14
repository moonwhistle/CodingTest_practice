import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int[][] map = new int[102][102];
	static boolean[][] visited = new boolean[102][102];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		drawAllRectangles(rectangle);    
        removeAllInner(rectangle);  
		answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
		return answer;
	}

	private int bfs(int cx, int cy, int ix, int iy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { cy, cx });
		visited[cy][cx] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();

				if (now[0] == iy && now[1] == ix) {
					return count;
				}

				for (int j = 0; j < 4; j++) {
					int y = now[0] + dy[j];
					int x = now[1] + dx[j];

					if (x >= 0 && x < 102 && y >= 0 && y < 102 && !visited[y][x] && map[y][x] == 1) {
						queue.add(new int[] { y, x });
						visited[y][x] = true;
					}
				}
			}

			count++;
		}

		return -1;
	}

	private void drawAllRectangles(int[][] rectangle) {
        for (int[] rec : rectangle) {
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int lx = rec[2] * 2;
            int ly = rec[3] * 2;

            for (int y = sy; y <= ly; y++) {
                for (int x = sx; x <= lx; x++) {
                    map[y][x] = 1;
                }
            }
        }
    }

    private void removeAllInner(int[][] rectangle) {
        for (int[] rec : rectangle) {
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int lx = rec[2] * 2;
            int ly = rec[3] * 2;

            for (int y = sy + 1; y < ly; y++) {
                for (int x = sx + 1; x < lx; x++) {
                    map[y][x] = 0;
                }
            }
        }
    }
}