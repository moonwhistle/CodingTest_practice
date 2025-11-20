import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			String line = input.next();

			if (isPalindrome(line.toCharArray())) {
				System.out.println("#" + i + " " + 1);
			} else {
				System.out.println("#" + i + " " + 0);
			}
		}
	}

	private static boolean isPalindrome(char[] lineArr) {
		int start = 0;
		int end = lineArr.length - 1;

		while (start < end) {
			if (lineArr[start] != lineArr[end]) {
				return false;
			}
			
			start++;
			end--;
		}

		return true;
	}
}