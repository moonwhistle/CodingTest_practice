import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = input.nextInt();
			int[] nums = new int[N];

			for (int j = 0; j < N; j++) {
				nums[j] = input.nextInt();
			}

			int min = 0;

			for (int j = 1; j < N; j++) {
				min += Math.abs(nums[j] - nums[j - 1]);
			}

			int answer = Integer.MAX_VALUE;

			for (int j = 1; j < N - 1; j++) {
				int origin = Math.abs(nums[j] - nums[j - 1]) + Math.abs(nums[j + 1] - nums[j]);
				int removed = Math.abs(nums[j + 1] - nums[j - 1]);
				answer = Math.min(answer, min - origin + removed);
			}

			System.out.println(answer);
		}
	}
}