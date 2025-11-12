import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static int[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int size = input.nextInt();
            map = new int[size][size];

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    map[y][x] = input.nextInt();
                }
            }

            int count = 0;
            for (int x = 0; x < size; x++) {
                Stack<Integer> stack = new Stack<>();

                for (int y = 0; y < size; y++) {
                    if (map[y][x] == 1) {
                        stack.push(1);
                    } else if (map[y][x] == 2) {
                        if (!stack.isEmpty() && stack.peek() == 1) {
                            count++;
                            stack.push(2);
                        }
                    }
                }
            }

            System.out.println("#" + i + " " + count);
        }
    }
}
