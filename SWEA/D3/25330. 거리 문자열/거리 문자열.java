import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCase = input.nextInt();

		for (int i = 1; i <= testCase; i++) {
			String line = input.next();
			Map<Character, Integer> existBox = new HashMap<>();
			boolean isSatisfied = true;

			for (int j = 0; j < line.length(); j++) {
				char now = line.charAt(j);
				existBox.put(now, existBox.getOrDefault(now, 0) + 1);

				if (existBox.get(now) < 2) {
					int nextIdx = j + 1 + (now - '0');

					if (nextIdx >= line.length() || now != line.charAt(nextIdx)) {
						isSatisfied = false;
						break;
					}
				} else if (existBox.get(now) == 2) {
					continue;
				} else {
					isSatisfied = false;
					break;
				}
			}

			if (isSatisfied) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
