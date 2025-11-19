
import java.util.Scanner;

class Solution {

	static int[][] map = new int[9][9];
	static Scanner input = new Scanner(System.in);
	static boolean isGood = true;

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
            isGood = true;
			setMap();
			validateRowAndCol();
			
			if (isGood) {
				validateSquare();

				if (isGood) {
					System.out.println("#" + i + " " + 1);
				} else {
					System.out.println("#" + i + " " + 0);
				}
			} else {
				System.out.println("#" + i + " " + 0);
			}
		}
	}

	private static void setMap() {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				map[y][x] = input.nextInt();
			}
		}
	}

	private static void validateRowAndCol() {
		int[] row;
		int[] col;

		for (int y = 0; y < 9; y++) {
			row = new int[10];
			col = new int[10];

			for (int x = 0; x < 9; x++) {
				row[map[y][x]]++;
				col[map[x][y]]++;

				if (row[map[y][x]] >= 2 || col[map[x][y]] >= 2) {
					isGood = false;
					return;
				}
			}
		}
	}

	private static void validateSquare() {
		for (int y = 0; y < 9; y += 3) {
			for (int x = 0; x < 9; x += 3) {
				int[] sum = new int[10];

				for (int yy = y; yy < y + 3; yy++) {
					for (int xx = x; xx < x + 3; xx++) {
						sum[map[yy][xx]]++;

						if (sum[map[yy][xx]] >= 2) {
							isGood = false;
							return;
						}
					}
				}
			}
		}
	}
}