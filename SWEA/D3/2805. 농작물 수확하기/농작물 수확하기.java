
import java.util.Scanner;

class Solution {

	static int[][] map;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = input.nextInt();
			int startY = N / 2;
			int sum = 0;

			map = new int[N][N];
			setMap(N);

			int count = 0;
			for (int y = startY; y < N; y++) {
				for (int x = count; x < N - count; x++) {
					if (y == startY) {
						sum += map[startY][x];
					} else {
						sum += map[startY + count][x];
						sum += map[startY - count][x];
					}
				}

				count++;
			}

			System.out.println("#" + i + " " + sum);
		}
	}

	private static void setMap(int N) {
		for (int i = 0; i < N; i++) {
			String line = input.next();

			int x = 0;

			for (char lineElement : line.toCharArray()) {
				map[i][x] = lineElement - '0';
				x++;
			}
		}
	}
}