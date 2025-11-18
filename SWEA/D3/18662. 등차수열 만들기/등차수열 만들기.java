import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();

			double A = Math.abs((2 * b - c) - a);
			double B = Math.abs(((a + c) / 2.0) - b);
			double C = Math.abs((2 * b - a) - c);

			double answer = Math.min(A, Math.min(B, C));

			System.out.printf("#%d %.1f\n", i, answer);
		}
	}
}