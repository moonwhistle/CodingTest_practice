
import java.util.Scanner;

class Solution {

	static int[][] map;
	static boolean[][] visitedRow;
	static boolean[][] visitedCol;
	static int count;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = input.nextInt();
			int size = input.nextInt();
			count = 0;

			map = new int[N][N];
			visitedRow = new boolean[N][N];
			visitedCol = new boolean[N][N];

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					map[y][x] = input.nextInt();
				}
			}

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == 1 && !visitedRow[y][x]) {
						visitedRow[y][x] = true;
						row(map, x, y, N, size);
					}

					if (map[y][x] == 1 && !visitedCol[y][x]) {
						visitedCol[y][x] = true;
						col(map, x, y, N, size);
					}
				}
			}

			System.out.println("#" + i + " " + count);
		}
	}

	private static void row(int[][] map, int x, int y, int N, int size) {
		int cnt = 0;

		for (int row = x; row < N; row++) {
			if (map[y][row] == 1) {
				visitedRow[y][row] = true;
				cnt++;
			} else {
				break;
			}
		}

		if (cnt == size) {
			count++;
		}
	}

	private static void col(int[][] map, int x, int y, int N, int size) {
		int cnt = 0;

		for (int col = y; col < N; col++) {
			if (map[col][x] == 1) {
				visitedCol[col][x] = true;
				cnt++;
			} else {
				break;
			}
		}

		if (cnt == size) {
			count++;
		}
	}
}