import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[] x = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] y = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int w = input.nextInt();
            int h = input.nextInt();
            int cnt = 0;

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            setMap(w, h, input);

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j, w, h);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int h, int w, int maxW, int maxH) {
        visited[h][w] = true;


        for (int i = 0; i < 8; i++) {
            int newX = w + x[i];
            int newY = h + y[i];

            if (newX >= 0 && newX < maxW && newY >= 0 && newY < maxH) {
                if (!visited[newY][newX] && map[newY][newX] == 1) {
                    dfs(newY, newX, maxW, maxH);
                }
            }
        }
    }

    private static void setMap(int w, int h, Scanner input) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = input.nextInt();
            }
        }
    }
}
