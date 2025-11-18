
import java.util.Scanner;

class Solution {

	static int[][] map;
	static int[] dx = { 1, -1, 0 };
	static int[] dy = { 0, 0, -1 };
	static boolean[][] visited;
	static int arrivedX;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int testCase = input.nextInt();
			map = new int[100][100];
			visited = new boolean[100][100];

			int startY = 0;
			int startX = 0;

			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					map[y][x] = input.nextInt();

					if (map[y][x] == 2) {
						startX = x;
						startY = y;
					}
				}
			}

			dfs(startY, startX);

			System.out.println("#" + testCase + " " + arrivedX);
		}
	}

	private static void dfs(int startY, int startX) {
		if (startY == 0) {
			arrivedX = startX;
		}

		visited[startY][startX] = true;

		for (int i = 0; i < 3; i++) {
			int x = dx[i] + startX;
			int y = dy[i] + startY;

			if (x >= 0 && y >= 0 && x < 100 && y < 100 && !visited[y][x] && map[y][x] == 1) {
				dfs(y, x);
                break;
			}
		}
	}
}