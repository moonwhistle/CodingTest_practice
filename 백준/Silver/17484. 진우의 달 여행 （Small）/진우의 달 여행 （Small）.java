import java.util.Scanner;

public class Main {

    static int[] x = {-1, 0, 1};
    static int[] y = {1, 1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        // 세팅
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = input.nextInt();
            }
        }

        // 백트래킹
        for (int i = 1; i < M + 1; i++) {
            back(1, i, N, M,-1, map[1][i]);
        }

        System.out.println(min);
    }

    private static void back(int startY, int startX, int N, int M, int prevX, int sum) {
        if (startY == N) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(i == prevX) {
                continue;
            }

            int newX = startX + x[i];
            int newY = startY + y[i];
            if (newX > 0 && newY > 0 && newX < M + 1 && newY < N + 1) {
                back(newY, newX, N, M, i, sum + map[newY][newX]);
            }
        }
    }
}
