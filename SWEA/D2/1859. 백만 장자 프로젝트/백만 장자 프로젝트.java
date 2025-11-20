import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = input.nextInt();
			int[] sells = new int[N];

			for (int j = 0; j < N; j++) {
				sells[j] = input.nextInt();
			}

			int end = N - 1;
			long sum = 0;

			for (int j = N - 2; j >= 0; j--) {
				int delimiter = sells[end];
				int now = sells[j];

				if (delimiter > now) {
					sum += (delimiter - now);
				} else {
					end = j;
				}
			}

			System.out.println("#" + i + " " + sum);
		}
	}
}