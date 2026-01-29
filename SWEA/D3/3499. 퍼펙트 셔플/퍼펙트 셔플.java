import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = input.nextInt();
			String[] result = new String[N];
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();

			// setting
			for (int i = 0; i < N; i++) {
				String given = input.next();

				if (Math.round(N / 2.0) > i) {
					q1.add(given);
				} else {
					q2.add(given);
				}
			}

			// pop
			int idx = 0;

			while (!q1.isEmpty() || !q2.isEmpty()) {
				if (idx % 2 == 0) {
					result[idx] = q1.poll();
				} else {
					result[idx] = q2.poll();
				}

				idx++;
			}

			// sout
			System.out.print("#" + t + " ");
			for (String resultElement : result) {
				System.out.print(resultElement + " ");
			}
			System.out.println();
		}
	}
}
