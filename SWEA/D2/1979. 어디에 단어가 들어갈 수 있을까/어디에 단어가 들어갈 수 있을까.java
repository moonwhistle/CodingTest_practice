import java.util.Scanner;

public class Solution {

    static int[][] map;
    static int cnt = 0;
    static int answer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int K = input.nextInt();

            map = new int[N][N];
            answer = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    map[y][x] = input.nextInt();
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] == 1) {
                        cnt++;
                    } else {
                        if (cnt == K) {
                            answer++;
                        }

                        cnt = 0;
                    }
                }

                if (cnt == K) {
                    answer++;
                }
                cnt = 0;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[x][y] == 1) {
                        cnt++;
                    } else {
                        if (cnt == K) {
                            answer++;
                        }

                        cnt = 0;
                    }
                }

                if (cnt == K) {
                    answer++;
                }
                cnt = 0;
            }

            System.out.println("#" + i + " " + answer);
        }
    }
}
