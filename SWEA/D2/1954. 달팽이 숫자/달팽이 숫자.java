import java.util.Scanner;

public class Solution {

	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCase = input.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = input.nextInt();
			map = new int[N][N];

			makeMap(N);

			System.out.println("#" + i);
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					System.out.print(map[y][x] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void makeMap(int N) {
		int i = 1;
		int x = 0;
		int y = 0;
		int mode = 0;

		while (i <= N * N) {
			map[y][x] = i;
			i++;

			if (x + dx[mode] < N && y + dy[mode] < N && x + dx[mode] >= 0 && y + dy[mode] >= 0
					&& map[y + dy[mode]][x + dx[mode]] == 0) {
				x += dx[mode];
				y += dy[mode];
			} else {
				mode = (mode + 1) % 4;
				x += dx[mode];
				y += dy[mode];
			}
		}
	}
}