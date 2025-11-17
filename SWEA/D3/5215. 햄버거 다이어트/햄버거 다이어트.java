import java.util.Scanner;

public class Solution {

	static int max;
	static Burger[] burgers;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCase = input.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = input.nextInt();
			int L = input.nextInt();
			max = Integer.MIN_VALUE;
			burgers = new Burger[N];

			for (int j = 0; j < N; j++) {
				int flavor = input.nextInt();
				int calory = input.nextInt();

				burgers[j] = new Burger(flavor, calory);
			}

			findMax(0, L, 0, N, 0);

			System.out.println("#" + i + " " + max);
		}
	}

	private static void findMax(int nowCalory, int maxCalory, int nowFlavor, int N, int start) {
		if (nowCalory > maxCalory) {
			return;
		}

		max = Math.max(max, nowFlavor);

		for (int i = start; i < N; i++) {
			findMax(nowCalory + burgers[i].calory(), maxCalory, nowFlavor + burgers[i].flavor(), N, i + 1);
		}
	}
}

class Burger {

	private final int flavor;
	private final int calory;

	public Burger(int flavor, int calory) {
		this.flavor = flavor;
		this.calory = calory;
	}

	public int flavor() {
		return this.flavor;
	}

	public int calory() {
		return this.calory;
	}
}