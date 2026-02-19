import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		// Please write your code here.
		btkPrint(k, n, new StringBuilder(), 0);
	}

	private static void btkPrint(int k, int n, StringBuilder sb, int depth) {
		if (depth == n) {
			System.out.println(sb.toString());
			return;
		}

		for (int i = 1; i <= k; i++) {
			int prevLength = sb.length();
			sb.append(i).append(" ");
			btkPrint(k, n, sb, depth + 1);
			sb.setLength(prevLength);
		}
	}
}