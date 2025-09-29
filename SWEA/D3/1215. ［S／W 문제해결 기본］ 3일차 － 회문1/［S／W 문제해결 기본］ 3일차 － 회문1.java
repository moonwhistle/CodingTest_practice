import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int test = 0; test < 10; test++) {
            int[][] map = new int[8][8];
            int length = input.nextInt();

            for (int i = 0; i < 8; i++) {
                String line = input.next();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    if (isPalindromeRow(map, i, j, length)) {
                        count++;
                    }
                }
            }

            for (int i = 0; i <= 8 - length; i++) {
                for (int j = 0; j < 8; j++) {
                    if (isPalindromeColumn(map, j, i, length)) {
                        count++;
                    }
                }
            }

            System.out.println("#" + (test + 1) + " " + count);
        }
    }

    private static boolean isPalindromeRow(int[][] map, int fix, int start, int length) {
        int end = start + length - 1;

        while (start <= end) {
            if (map[fix][start] != map[fix][end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean isPalindromeColumn(int[][] map, int fix, int start, int length) {
        int end = start + length - 1;

        while (start <= end) {
            if (map[start][fix] != map[end][fix]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
