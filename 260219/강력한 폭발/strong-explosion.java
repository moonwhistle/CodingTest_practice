import java.util.Scanner;
import java.util.*;

public class Main {

	static List<List<Integer>> list;
	static int max;
	static List<Point> points;
	static final int[][] TYPE1 = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 2, 0 }, { -2, 0 } };

	static final int[][] TYPE2 = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static final int[][] TYPE3 = { { 0, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		// Please write your code here.
		list = new ArrayList<>();
		points = new ArrayList<>();
		max = Integer.MIN_VALUE;
		int size = getSize(grid, n);
		btk(size, 0, new ArrayList<>());
		cal(grid, n, size);
		System.out.println(max);
	}

	private static void cal(int[][] grid, int n, int size) {
		int[][] copy = new int[n][n];

		for (List<Integer> element : list) {
			for (int i = 0; i < n; i++) {
				copy[i] = Arrays.copyOf(grid[i], n);
			}

			int count = size;

			for (int i = 0; i < element.size(); i++) {
				int option = element.get(i);
				Point point = points.get(i);
				count += explode(copy, point, option, n);
			}
			
			max = Math.max(count, max);
		}
	}

	private static int explode(int[][] copy, Point p, int type, int n) {
		int[][] pattern = getPattern(type);
		int cnt = 0;

		for (int[] d : pattern) {
			int ny = p.y + d[0];
			int nx = p.x + d[1];

			if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
				continue;
			}

			if (copy[ny][nx] == 0) {
				cnt++;
			}

			copy[ny][nx] = 1;
		}

		return cnt;
	}

	private static int[][] getPattern(int type) {
		switch (type) {
		case 1:
			return TYPE1;
		case 2:
			return TYPE2;
		case 3:
			return TYPE3;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static void btk(int size, int depth, List<Integer> box) {
		if (depth == size) {
			list.add(new ArrayList<>(box));
			return;
		}

		for (int i = 1; i < 4; i++) {
			box.add(i);
			btk(size, depth + 1, box);
			box.remove(box.size() - 1);
		}
	}

	private static int getSize(int[][] grid, int n) {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					points.add(new Point(i, j));
					cnt++;
				}
			}
		}

		return cnt;
	}
}

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}