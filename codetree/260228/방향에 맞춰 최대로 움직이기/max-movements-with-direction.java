import java.util.Scanner;

public class Main {

    static int n;
    static int[][] num;
    static int[][] moveDir;
    static boolean[][] visited;
    static int max;
    static int[] dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        r--;
        c--;
        max = 0;
        // Please write your code here.
        visited[r][c] = true;
        btk(0, moveDir[r][c], r, c);
        System.out.println(max);
    }

    private static void btk(int count, int i, int y, int x) {
        int ny = y;
        int nx = x;

        while (true) {
            ny += dy[i];
            nx += dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                max = Math.max(count, max);
                return;
            }

            if(num[ny][nx] < num[y][x]) {
                max = Math.max(count, max);
                continue;
            }

            if(!visited[ny][nx]) {
                visited[ny][nx] = true;
                btk(count + 1, moveDir[ny][nx], ny, nx);
                visited[ny][nx] = false;
            }
        }
    }
}
