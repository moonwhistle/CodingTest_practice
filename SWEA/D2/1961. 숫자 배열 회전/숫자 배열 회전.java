import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int T = input.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int size = input.nextInt();

            int[][] map = new int[size][size];
            makeMap(map);

            ArrayList<String>[] answer = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                answer[i] = new ArrayList<String>();
            }

            for (int i = 0; i < 3; i++) {
                transpose(map, size);
                reverseRow(map, size);

                for (int row = 0; row < size; row++) {
                    String lineElement = "";

                    for (int col = 0; col < size; col++) {
                        lineElement += map[row][col];
                    }

                    answer[row].add(lineElement);
                }
            }

            // 출력
            System.out.println("#" + testCase + " ");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(answer[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private static void makeMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = input.nextInt();
            }
        }
    }

    private static void transpose(int[][] map, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int tmp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = tmp;
            }
        }
    }

    private static void reverseRow(int[][] map, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int tmp = map[i][j];
                map[i][j] = map[i][size - j - 1];
                map[i][size - j - 1] = tmp;
            }
        }
    }
}
