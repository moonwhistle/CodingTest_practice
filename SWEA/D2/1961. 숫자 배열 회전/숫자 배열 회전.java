import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    static Scanner input = new Scanner(System.in);
    static int[][] map;
    static ArrayList<String>[] result;

    public static void main(String[] args) {
        int T = input.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = input.nextInt();
            map = new int[N][N];
            result = new ArrayList[N];
            initResult(N);
            setMap(N);

            for (int i = 0; i < 3; i++) {
                transpose(N);
                reverseRow(N);
                setResult(N);
            }

            System.out.println("#" + t);
            for (ArrayList<String> line : result) {
                for (String lineElement : line) {
                    System.out.print(lineElement + " ");
                }
                System.out.println();
            }
        }
    }

    private static void initResult(int N) {
        for (int i = 0; i < N; i++) {
            result[i] = new ArrayList<>();
        }
    }

    private static void setResult(int N) {
        for (int y = 0; y < N; y++) {
            String line = "";

            for (int x = 0; x < N; x++) {
                line += String.valueOf(map[y][x]);
            }

            result[y].add(line);
        }
    }

    private static void reverseRow(int N) {
        for (int y = 0; y < N; y++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                int tmp = map[y][start];
                map[y][start] = map[y][end];
                map[y][end] = tmp;

                start++;
                end--;
            }
        }
    }

    private static void transpose(int N) {
        for (int y = 0; y < N; y++) {
            for (int x = y + 1; x < N; x++) {
                int temp = map[y][x];
                map[y][x] = map[x][y];
                map[x][y] = temp;
            }
        }
    }

    private static void setMap(int N) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = input.nextInt();
            }
        }
    }
}
