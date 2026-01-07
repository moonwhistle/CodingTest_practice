import java.util.HashMap;
import java.util.Map;

public class Solution {

	static Map<Integer, Point> keypad = new HashMap<>();
	static Point right = new Point(2, 3);
	static Point left = new Point(0, 3);

	public static void main(String args[]) throws Exception {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
	}

	public static String solution(int[] numbers, String hand) {
		buildKeypad();
		String answer = "";

		for (int number : numbers) {
			Point keypadPoint = keypad.get(number);

			if (number == 1 || number == 4 || number == 7) {
				answer += "L";
				left.changeY(keypadPoint.y);
				left.changeX(keypadPoint.x);
			} else if (number == 3 || number == 6 || number == 9) {
				answer += "R";
				right.changeY(keypadPoint.y);
				right.changeX(keypadPoint.x);
			} else {
				int leftDistance = keypadPoint.distance(left.x, left.y);
				int rightDistance = keypadPoint.distance(right.x, right.y);
				boolean isRight = true;

				if (leftDistance == rightDistance) {
					if (hand.equals("right")) {
						isRight = true;
					} else {
						isRight = false;
					}
				} else if (leftDistance < rightDistance) {
					isRight = false;
				} else {
					isRight = true;
				}

				if (isRight) {
					answer += "R";
					right.changeY(keypadPoint.y);
					right.changeX(keypadPoint.x);
				} else {
					answer += "L";
					left.changeY(keypadPoint.y);
					left.changeX(keypadPoint.x);
				}
			}
		}

		return answer;
	}

	private static void buildKeypad() {
		keypad.put(1, new Point(0, 0));
		keypad.put(2, new Point(1, 0));
		keypad.put(3, new Point(2, 0));
		keypad.put(4, new Point(0, 1));
		keypad.put(5, new Point(1, 1));
		keypad.put(6, new Point(2, 1));
		keypad.put(7, new Point(0, 2));
		keypad.put(8, new Point(1, 2));
		keypad.put(9, new Point(2, 2));
		keypad.put(0, new Point(1, 3));
	}

	static class Point {

		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int x() {
			return this.x;
		}

		public int y() {
			return this.y;
		}

		public int distance(int x, int y) {
			return Math.abs(this.x - x) + Math.abs(this.y - y);
		}

		public void changeY(int y) {
			this.y = y;
		}

		public void changeX(int x) {
			this.x = x;
		}
	}
}