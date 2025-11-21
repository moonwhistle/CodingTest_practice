import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			int sizeA = input.nextInt();
			int sizeB = input.nextInt();
			int[] nums = new int[101];
			int sameCount = 0;

			for (int j = 0; j < sizeA; j++) {
				nums[input.nextInt()]++;
			}

			for (int j = 0; j < sizeB; j++) {
				int num = input.nextInt();

				nums[num]++;

				if (nums[num] == 2) {
					sameCount++;
				}
			}

			if (sameCount == sizeA && sameCount == sizeB) {
				System.out.println("=");
			} else if (sameCount == sizeA) {
				System.out.println("<");
			} else if (sameCount == sizeB) {
				System.out.println(">");
			} else {
				System.out.println("?");
			}
		}
	}
}