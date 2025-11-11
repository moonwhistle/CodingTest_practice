import java.util.Scanner;
import javax.swing.Spring;
import javax.swing.plaf.IconUIResource;

public class Solution {

    static char[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int length = input.nextInt();
            map = new char[8][8];
            int cnt = 0;

            for (int y = 0; y < 8; y++) {
                String line = input.next();
                int x = 0;

                for (char lineElement : line.toCharArray()) {
                    map[y][x] = lineElement;
                    x++;
                }
            }

            // row
            for (int y = 0; y < 8; y++) {
                char[] row = map[y];

                for (int x = length - 1; x < 8; x++) {
                    int start = x - length + 1;

                    if (isPan(start, x, row)) {
                        cnt++;
                    }
                }
            }

            // col
            for (int x = 0; x < 8; x++) {
                char[] col = makeCol(x);

                for (int y = length - 1; y < 8; y++) {
                    int start = y - length + 1;

                    if (isPan(start, y, col)) {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + i + " " + cnt);
        }
    }

    private static char[] makeCol(int x) {
        char[] line = new char[8];

        for (int i = 0; i < 8; i++) {
            line[i] = map[i][x];
        }

        return line;
    }

    private static boolean isPan(int start, int end, char[] line) {
        while (start < end) {
            if (line[start] != line[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
