import java.util.Scanner;
public class Main {
    static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// Please write your code here.
		btk(n, 0, new StringBuilder());
		System.out.println(cnt);
	}

	private static void btk(int n, int depth, StringBuilder sb) {
		if (depth == n) {
			char prev = sb.charAt(0);
			int count = 1;

			// 갱신 및 확인 로직
			for (int i = 1; i < sb.length(); i++) {
				char now = sb.charAt(i);

				if (now == prev) {
					count++;
				} else {
					if (count % (prev - '0') != 0) {
						return;
					}

					prev = now;
					count = 1;
				}
			}

			// 후처리
			if (count % (prev - '0') != 0) {
				return;
			}

			cnt++;
			return;
		}

		for (int i = 1; i <= 4; i++) {
			sb.append(i);
			btk(n, depth + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}