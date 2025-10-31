import java.util.Objects;
import java.util.Scanner;

public class Solution {

    static String[][] map = new String[100][100];
    static int max;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int testCase = input.nextInt();
            max = Integer.MIN_VALUE;
            
            for (int y = 0; y < 100; y++) {
                String line = input.next();
                int x = 0;

                for (String lineElement : line.split("")) {
                    map[y][x] = lineElement;
                    x++;
                }
            }

            // row
            for (int y = 0; y < 100; y++) {
                findMaxLength(map[y]);
            }

            // column
            for(int x = 0 ; x< 100; x ++) {
                String[] col = new String[100];

                for(int y = 0 ; y<100; y++) {
                    col[y] = map[y][x];
                }

                findMaxLength(col);
            }

            System.out.println("#" + testCase + " " + max);
        }
    }

    private static void findMaxLength(String[] line) {
        for (int l = 100; l > 0; l--) {
            for (int j = 0; j + l <= 100; j++) {
                if (isPalindrome(j, j + l - 1, line)) {
                    max = Math.max(l, max);
                    return;
                }
            }
        }
    }

    private static boolean isPalindrome(int start, int end, String[] line) {
        while (start < end) {
            if (!Objects.equals(line[start], line[end])) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
