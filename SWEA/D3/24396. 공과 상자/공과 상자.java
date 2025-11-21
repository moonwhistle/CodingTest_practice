import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int B = input.nextInt();
			int W = input.nextInt();
			int X = input.nextInt();
			int Y = input.nextInt();
			int Z = input.nextInt();
			int max = Integer.MIN_VALUE;
			int ball = 0;
			boolean isB = false;
			boolean isW = false;

			if (B >= W) {
				ball = W;
				isW = true;
			} else {
				ball = B;
				isB = true;
			}

			while (ball >= 0) {
				if (isB) {
					int reverse = B - ball;
					int sumBlack = ball * X;
					int sumWhite = (W - reverse) * Y;
					int reverseSum = reverse * Z * 2;

					max = Math.max(max, sumBlack + sumWhite + reverseSum);
				} else {
					int reverse = W - ball;
					int sumBlack = (B - reverse) * X;
					int sumWhite = ball * Y;
					int reverseSum = reverse * Z * 2;

					max = Math.max(max, sumBlack + sumWhite + reverseSum);
				}

				ball--;
			}

			System.out.println(max);
		}
	}
}